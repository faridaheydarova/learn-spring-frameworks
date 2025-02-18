package az.developia.spring_rest_project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentAddRequestDTO {
	
	@NotNull(message= "name can't be null")
	@NotBlank(message= "name can't be empty")
	private String name;
	
	@Min(value =18, message="minimum age should be 18")
	private int age;
	
	private String phone;
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
