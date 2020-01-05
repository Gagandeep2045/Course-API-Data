package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,Integer>
//<Entity class, primary key of that class>
//basic/standard curd on Topic Class are implemented by CurdRepository interface
{

	
	
}
