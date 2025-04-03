package az.developia.spring_rest_project.entity;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import az.developia.spring_rest_project.service.MyService;

@Aspect
@Component
public class MyAspect {
	
	
	
	  @Before("execution(public void doSomeThing())")
	public void logBeforeMethodCall() {
		
		System.out.println("Method call!");
	}

}
