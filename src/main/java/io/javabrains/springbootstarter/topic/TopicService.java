package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List <Topic> getAllTopics()
	{
		List<Topic> tt= new ArrayList<Topic>();
		topicRepository.findAll().forEach(t -> tt.add(t));
		return tt;
	}
	
	
	public Topic getTopic(int id)
	{
		
		return topicRepository.findOne(id);
				
	}
	
	public void addTopic(Topic t)
	{
		
		topicRepository.save(t); //if row doesnt exists inserts else updates
	}

	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(int topicId) {
		topicRepository.delete(topicId);
	}
	
}
