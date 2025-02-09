package tr.project.kerem.syndicate.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tr.project.kerem.syndicate.dto.RegisterRequest;
import tr.project.kerem.syndicate.entities.User;
import tr.project.kerem.syndicate.repositories.UserRepository;

@Service
public class AuthService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public String register(RegisterRequest request) {
		if (!request.getPassword().equals(request.getConfirmPassword())) {
			throw new RuntimeException("Şifreler uyuşmuyor!");
		}
		
		Optional<User> existingUser = userRepository.findByUsername(request.getUsername());
		if (existingUser.isPresent()) {
			throw new RuntimeException("Bu kullanıcı adı zaten kullanılıyor!");
		}
		
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		userRepository.save(user);
		return "Kullanıcı başarıyla kaydedildi.";
	}
}
