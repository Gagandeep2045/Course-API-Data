package io.javabrains;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.javabrains.springbootstarter.course.Course;
import io.javabrains.springbootstarter.course.Response;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CourseControllerTest {
	
	@Autowired
	WebApplicationContext ac;
	
	MockMvc mockMVC;
	
	ObjectMapper om = new ObjectMapper();
	
	@Before()
	public void setUp()
	{
		mockMVC= MockMvcBuilders.webAppContextSetup(ac).build();
	}

	@Test()
	public void testAddCourseOfCourseControllerForUnitTestingDemo() throws Exception
	{
		Course c = new Course(101,"Maths");
		String jsonRequest = om.writeValueAsString(c);
		MvcResult result=mockMVC.perform(post("/course/add").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	    String jsonResponse=result.getResponse().getContentAsString();
	    Response r=om.readValue(jsonResponse, Response.class);
	    Assert.assertEquals( r.status, "success");
	}
}
