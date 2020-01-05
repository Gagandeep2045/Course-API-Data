package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.topic.Topic;

@Service
public class CourseService {

	
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List <Course> getAllCourses(int topicId)
	{List <Course> courses = new ArrayList<Course>();
		courseRepository.findAll().forEach( t -> {if(t.getTopic().getTopicId()==topicId) courses.add(t);});
	return courses;
	}
	
	public Course getCourse(int id)
	{
		
		Course c= courseRepository.findOne(id);
		
	return c;
	}
	
	public void addCourse(Course t)
	{
		
		courseRepository.save(t); //if row doesnt exists inserts else updates
	}

	public void updateCourse(Course course) {
		
		courseRepository.save(course);
	}

	public void deleteTopic(int topicId) {
		courseRepository.delete(topicId);
	}

	public List<Course> getCoursesByName(String name) {
		// TODO Auto-generated method stub
		return courseRepository.findByCourseName(name);
	}

	public List<Course> getCoursesByTopicId(int id) {
		// TODO Auto-generated method stub
		return courseRepository.findByTopicTopicId(id);
		
		
	}
	
}
