package az.developia.spring_rest_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {

	@Scheduled(fixedDelay=5, initialDelay=5000)
	public void method1() {
		System.out.println("Ders davam edir");
		
	}
}
