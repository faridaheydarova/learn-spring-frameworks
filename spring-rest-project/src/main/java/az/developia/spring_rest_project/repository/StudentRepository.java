package az.developia.spring_rest_project.repository;

import az.developia.spring_rest_project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
@Query(value = "select*from students where name like %?1%", nativeQuery = true)
    public List<Student>findSearch(String name);


    public List<Student>findAllByAge(int age);
}
