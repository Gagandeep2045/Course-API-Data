package io.javabrains.springbootstarter.topic;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.javabrains.springbootstarter.course.Course;


/*JavaBeans are classes that encapsulate many objects into a single object (the bean). 
 * They are serializable, have a zero-argument constructor,
 
 *  and allow access to properties using getter and setter methods./*
 */
@Entity()
public class Topic  {  //wont work without getters and setters.. working without implementing serializable
@Id()
	private int topicId;
	


		public int getTopicId() {
		return topicId;
	}

		@OneToMany(mappedBy="topic")
		private List<Course> course;
		
		@JsonIgnore() // no json will be created for List<Course> when Topic object is returned by controller method
		public List<Course> getCourse()
		{
			return course;
		}
		
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

		private String topicName;

	public Topic(int topicId, String topicName) {
		this.topicId = topicId;
		this.topicName = topicName;
	}
	
	public Topic() // this is must
	{}
	
}

/*The Jackson annotation @JsonIgnore is used to tell Jackson to ignore a certain property (field) of a Java object. 
 * The property is ignored both when reading JSON into Java objects, and when writing Java objects into JSON. 

 */

/*


Will have to make either property List<Course> in Topic class or property Topic in Course class as  @JsonIgnore
to avoid any improper syntax of json to be craeted as infinite recursion takes place
refer https://stackoverflow.com/questions/37848789/spring-expected-instead-of-t-error-when-returning-list
*/