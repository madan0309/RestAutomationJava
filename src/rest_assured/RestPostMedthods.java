package rest_assured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestPostMedthods {
	@Test
	public void PostUserRegistration() {
		//Base URL
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Rest Request Specification
		RequestSpecification httpRequest = RestAssured.given();
		
		//Create Json Body
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Madan");
		requestParams.put("LastName", "Mohan");	 
		requestParams.put("UserName", "madan0309");
		requestParams.put("Password", "Madan@sdet");
		requestParams.put("Email",  "madan03329@gmail.com");
		
		System.out.println(requestParams.toJSONString());
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		
		//Post Request
		Response response = httpRequest.post("/register");
		
		//Validation
		//Status Code
		int statuscode = response.getStatusCode();
		System.out.println("Post Status Code : "+statuscode);
		Assert.assertEquals(statuscode, 201, "Status Code is not Expected");
		
		Assert.assertEquals(response.jsonPath().get("SuccessCode"), "OPERATION_SUCCESS", "Success Code Error");
		
		System.out.println("Response Body : "+response.body().asString());
		
	}
}
