package az.developia.spring_rest_project.dto;

import lombok.Data;

@Data
public class StudentResponseDTO {
    private  Long id;
    private String name;
    private int age;
    private String phone;
}
