package az.developia.spring_rest_project.entity;

import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="managers")
@Data
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phone;
	
	@OneToMany(mappedBy="manager")
	private List<Student> students;
	
}
