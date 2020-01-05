package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Integer>
//<Entity class, primary key of that class>
//basic/standard curd on Topic Class are implemented by CurdRepository interface
{

	public List<Course> findByCourseName(String name); //findByProperty() returns list of object of entity class
	//having property value= name provided ... defination not to be given... spring automatically provides definition
	
	public List<Course>findByTopicTopicId(int id); //findByClassPropertyOfClass if u wish to filter with property of a class
//follow camel casing
}
