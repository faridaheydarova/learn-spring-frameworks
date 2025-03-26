package az.developia.spring_rest_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import az.developia.spring_rest_project.entity.UserEntity;


@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String>{ 
	

	@Query(value="INSERT INTO authorities (username, authority) SELECT ?1, authority FROM authority_list WHERE manager=1"
			+ " ", nativeQuery = true)
	@Modifying
void addUserAuthorities(String username);
}
