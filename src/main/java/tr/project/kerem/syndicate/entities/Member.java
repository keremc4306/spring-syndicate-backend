package tr.project.kerem.syndicate.entities;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import tr.project.kerem.syndicate.enums.Gender;
import tr.project.kerem.syndicate.enums.MemType;
import tr.project.kerem.syndicate.enums.MethodOfPayment;
import tr.project.kerem.syndicate.enums.PaymentStatus;
import tr.project.kerem.syndicate.enums.WorkCondition;

@Data
@Entity
@Table(name="members")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "surname", nullable = false, length = 50)
	private String surname;
	
	@Column(unique = true, nullable = false, length = 11)
	private Long trIdNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(unique = true, nullable = false, length = 11)
	private LocalDate dateOfBirth;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@jakarta.validation.constraints.Pattern(regexp = "\\(\\d{3}\\) \\d{3} \\d{2} \\d{2}",
			message = "Invalid phone number format. Expected: (XXX) XXX XX XX")
    private String mobilePhoneNumber;
	
	@Column(name = "cityName", nullable = false, length = 50)
	private String cityName;
	
	@Column(name = "district", nullable = false, length = 50)
	private String district;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(unique = true, nullable = false, length = 11)
	private LocalDate memStartDate;
	
	@Enumerated(EnumType.STRING)
	private MemType memType;
	
	@Column(unique = true, nullable = false, length = 15)
	private Long memNumber;
	
	@Column(name = "companyName", nullable = false, length = 50)
	private String companyName;
	
	@Column(name = "title", nullable = false, length = 50)
	private String title;
	
	
	@Enumerated(EnumType.STRING)
	private WorkCondition workCondition;
	
	@Column(name = "unit", nullable = false, length = 50)
	private String unit;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@Column(name = "amountOfDue", nullable = false, length = 10)
	private Double amountOfDue;
	
	@Enumerated(EnumType.STRING)
	private MethodOfPayment methodOfPayment;
}
