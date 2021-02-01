package br.com.comexport.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@SuppressWarnings("deprecation")
public class RegisterDTO {
	
	private Long id;

	@NotEmpty(message = "The name cannot be empty!")
	private String name;

	@NotEmpty(message = "The email cannot be empty!")
	@Email(message = "email invalid!")
	private String email;

	@NotEmpty(message = "The dateOfBirth cannot be empty!")
	private String dateOfBirth;

}
