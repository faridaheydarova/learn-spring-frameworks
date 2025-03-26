package az.developia.spring_rest_project.dto;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserAddRequestDTO {
	
	@NotNull(message= "name can't be null")
	@NotBlank(message= "name can't be empty")
	private String username;
	
	private String password;
	

}
