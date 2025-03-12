package az.developia.spring_rest_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.spring_rest_project.entity.Authority;

public interface AuthoriyRepository  extends JpaRepository<Authority, Long>{
	

}
