package az.developia.spring_rest_project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatchers;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
@Bean 
public UserDetailsService userDetailService() {
	JdbcDaoImpl jdbcDao= new JdbcDaoImpl();
	jdbcDao.setDataSource(dataSource);
	return jdbcDao;
	
}


@Bean
public AuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authProvider =new DaoAuthenticationProvider();
	authProvider.setUserDetailsService(userDetailService());
	return authProvider;
}
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
        	.requestMatchers(HttpMethod.POST, "/users/**").permitAll()
        	.requestMatchers(HttpMethod.GET, "/users/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/files/**").hasRole("UPLOAD_FILE")
            .requestMatchers(HttpMethod.GET, "/files/**").hasRole("DOWNLOAD_FILE")
            
        )
        .formLogin(Customizer.withDefaults()) 
        .httpBasic(Customizer.withDefaults()); 
    return http.build();
}

}
