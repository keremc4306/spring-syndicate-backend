package tr.project.kerem.syndicate.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterRequest {
	@NotBlank(message = "Kullanıcı adı boş olamaz")
	private String username;
	
	@NotBlank(message = "Şifre boş olamaz")
    @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{6,}$", 
    message = "Şifre en az bir büyük harf, bir küçük harf ve bir noktalama işareti içermelidir")
	private String password;
	
	@NotBlank(message = "Şifre tekrarı boş olamaz")
	private String confirmPassword;
}
