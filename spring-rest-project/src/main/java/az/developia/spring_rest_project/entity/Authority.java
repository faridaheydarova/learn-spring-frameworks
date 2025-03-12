package az.developia.spring_rest_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="authority")

public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
private String username;
private String authority;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getAuthority() {
	return authority;
}
public void setAuthority(String authority) {
	this.authority = authority;
}



}
