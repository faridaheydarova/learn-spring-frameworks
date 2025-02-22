package az.developia.spring_rest_project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentUpdateRequestDTO {
	
	private Long id;

	@NotNull(message= "name can't be null")
	@NotBlank(message= "name can't be empty")
	private String name;
	
	@Min(value =18, message="minimum age should be 18")
	private int age;
	
	@Pattern(regexp = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}", message="nömre formatını düzgün qeyd edin")
	private String phone;
	
}
