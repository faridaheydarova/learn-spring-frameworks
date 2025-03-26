package az.developia.spring_rest_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class UserEntity {
		@Id
	
		private String username;
		private String password;
		private Integer enabled;
		
		public UserEntity(String username, String password, Integer enabled) {
			super();
			this.username = username;
			this.password = password;
			this.enabled = enabled;
		}
		
		public UserEntity() {
			
		}
		
		

}
