package rest_assured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAuthentication {
	//Test without giving credentials
	//Response is 401 status
	@Test
	public void InvalidAuther() {
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RequestSpecification request = RestAssured.given();
		
		
		Response response = request.get();
		
		System.out.println("Response Status Code : "+ response.getStatusCode());
		System.out.println("Response Message : "+ response.body().asString());
	}
	
	@Test
	public void ValidAuthentication() {
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RequestSpecification request = RestAssured.given().auth().basic("ToolsQA", "TestPassword");
		
		Response response = request.get();
		System.out.println("Response Status Code : "+ response.getStatusCode());
		System.out.println("Response Message : "+ response.body().asString());

	}
	
	
}
