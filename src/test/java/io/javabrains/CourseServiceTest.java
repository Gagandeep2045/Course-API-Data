package io.javabrains;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.javabrains.springbootstarter.course.Course;
import io.javabrains.springbootstarter.course.CourseRepository;
import io.javabrains.springbootstarter.course.CourseService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class CourseServiceTest {

	@MockBean()
	private CourseRepository courseRepository;

	@Autowired()
	private CourseService service;

	@Test()
	public void testGetCourse()
	{int courseId=1;
	Course course= new Course();
	course.setCourseId(1);
	course.setCourseName("FA1");
	when(courseRepository.findOne(courseId)).thenReturn(course);
	assertEquals(course, service.getCourse(courseId));	
	verify(courseRepository,times(1)).findOne(courseId);
	}

	@Test()
	public void testAddCourse()
	{
		Course course= new Course();
		course.setCourseId(101);
		course.setCourseName("Maths");
		//when(courseRepository.save(course)).thenReturn(course);
		service.addCourse(course);
		verify(courseRepository,times(1)).save(course);
	}

	@Test()
	public void testGetCoursesByName()
	{
		String courseName="Math";
		List<Course> courses =new ArrayList(Arrays.asList(new Course(1,"Maths"),new Course(100,"Maths") )) ;
		when(courseRepository.findByCourseName(courseName)).thenReturn(courses);
		List courses1= service.getCoursesByName(courseName);
		Assert.assertEquals(courses.toArray(), courses1.toArray());
		verify(courseRepository,times(1)).findByCourseName(courseName);
	}

}
