 package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TopicController {

	@Autowired() //If not autowired a separate instance of service created , verify it with diff hashcode values
	private  TopicService topicService;// = new TopicService();;
	//no need to instantiate it the Spring automatically injects the Service instance by looking at Autowired annotation
	
	@RequestMapping("/topics")
	public List<Topic> getTopics()
	{List <Topic>l= topicService.getAllTopics();
	
	System.out.println("Hascode value of Topic Service  in Topic Controller"+topicService.hashCode());
	return l;
	}	

	
	@RequestMapping("/see")
	public String p()
	{
		
		return "hello";
		
	}
	

	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable() int id)
	{
		return topicService.getTopic(id);
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody()Topic topic)
	{
		
		topicService.addTopic(topic);
	}


@RequestMapping(method=RequestMethod.PUT,value="/updateTopics")
public void updateTopic(@RequestBody()Topic topic)
{
topicService.updateTopic(topic);	

}


@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
public void deleteTopic(@PathVariable("id") int topicId)
{
	
topicService.deleteTopic(topicId);
}



}
