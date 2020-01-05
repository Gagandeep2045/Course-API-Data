package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiDataApplication.class, args);
		System.out.println("hello");
	}

/* spring actuator -> monitorand manage appln in any env (prod env).. get health etc *.. added dependency of actuator in pom.xml file */
/* https://spring.io/guides/gs/actuator-service/ */
}
