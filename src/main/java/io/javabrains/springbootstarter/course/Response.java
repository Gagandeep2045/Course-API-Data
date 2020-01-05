package io.javabrains.springbootstarter.course;

public class Response {

	public String status;
	public String message;
	public Response(String status, String message) {
		
		this.status = status;
		this.message = message;
	}
	
	public Response()
	{
		
	}
	
}
