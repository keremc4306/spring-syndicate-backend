package tr.project.kerem.syndicate.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Kullanıcı adı boş olamaz")
	@Column(unique = true)
	private String username;
	
	@NotBlank(message = "Şifre boş olamaz")
	@Size(min = 6, message = "Şifre en az 6 karakterli olmalıdır.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\p{Punct}).+$",
		    message = "Şifre en az bir büyük harf ve bir küçük harf içermelidir")
	private String password;
	
}
