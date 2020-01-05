package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/course")
public class CourseControllerForUnitTestingDemo {

	@Autowired
	CourseService service;
	
	@PostMapping("/add")
	public Response addCourse(@RequestBody() Course c)
	{
		service.addCourse(c);
		return new Response("success","Course Added");
	}
}
