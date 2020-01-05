package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.javabrains.springbootstarter.topic.Topic;

@RestController()
public class CourseController {

	@Autowired() //If not autowired a separate instance of service created , verify it with diff hashcode values
	private  CourseService courseService;// = new TopicService();;
	//no need to instantiate it the Spring automatically injects the Service instance by looking at Autowired annotation
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable() int id)
	{
		List<Course> l= courseService.getCoursesByTopicId(id);
	//List <Course> l = courseService.getAllCourses(id);
	//l.stream().forEach(t->System.out.println(t.getTopic().getTopicId()+" "+t.getTopic().getTopicName()));
	return l;
	}	

	
	
	
	@RequestMapping("/courses/{id}")
	public Course getCourse(@PathVariable() int id)
	{
		Course c= courseService.getCourse(id);
		
		
		return c;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody() Course course, @PathVariable int topicId)
	{
		System.out.println("1:"+course.getCourseId());
		System.out.println("2:"+course.getCourseName());
		//System.out.println("3:"+course.getTopic().getTopicId());
		//System.out.println("4:"+course.getTopic().getTopicName());
		System.out.println("5:"+topicId);
		Topic t=new Topic();
				t.setTopicId(topicId);
		course.setTopic(t);
		courseService.addCourse(course);
	}


@RequestMapping(method=RequestMethod.PUT,value="/courses/{id}")
public void updateCourse(@RequestBody()Course course,@PathVariable("id") int topicId)
{Topic t = new Topic();
t.setTopicId(topicId);
course.setTopic(t);
courseService.updateCourse(course);	

}


@RequestMapping(method=RequestMethod.DELETE,value="/courses/{id}")
public void deleteTopic(@PathVariable("id") int courseId)
{
	
courseService.deleteTopic(courseId);
}


@RequestMapping("/courses/{name}")
public List<Course> getCourses(@PathVariable String name)
{
	
return courseService.getCoursesByName(name);

}



}
