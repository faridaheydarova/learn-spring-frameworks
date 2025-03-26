package az.developia.spring_rest_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.spring_rest_project.entity.Authorities;


public interface AuthoriesRepository  extends JpaRepository<Authorities, Long>{

	List<Authorities> findAllByUsername(String username);
	

}
