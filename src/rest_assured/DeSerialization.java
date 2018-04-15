package rest_assured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeSerialization {
	@Test
	public class RegistrationSuccessResponse {
		public String SuccessCode;
		public String Message;
	}
	@Test
	public void PostOperationWithSerialization() {
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
				
				
				System.out.println(response.body().asString());
				RegistrationSuccessResponse responseBody = response.getBody().as(RegistrationSuccessResponse.class);
				System.out.println("Post response Message : "+responseBody.Message);
				System.out.println("Post response Successcode : "+responseBody.SuccessCode);
	}
}
