package io.javabrains.springbootstarter.course;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.javabrains.springbootstarter.topic.Topic;


/*JavaBeans are classes that encapsulate many objects into a single object (the bean). 
 * They are serializable, have a zero-argument constructor,
 
 *  and allow access to properties using getter and setter methods./*
 */
@Entity()
public class Course  {  //wont work without getters and setters.. working without implementing serializable
	
	
	
@Id()
	private int courseId;
	
		public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

		private String courseName;

	public Course(int courseId, String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
	}
	
	public Course() // this is must
	{}
	
	
	@ManyToOne()
	private Topic topic;
	
	//@JsonIgnore() // no json will be created for property Topic when Course object is returned by Course Controller
	public Topic getTopic()
	{
		return topic;		
		
	}
	

	public void setTopic(Topic t) {
		// TODO Auto-generated method stub
		this.topic=t;
	}
}
