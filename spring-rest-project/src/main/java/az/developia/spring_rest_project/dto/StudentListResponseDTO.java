package az.developia.spring_rest_project.dto;

import az.developia.spring_rest_project.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentListResponseDTO {
    private List<StudentResponseEntityDTO> students;
}
