package rest_assured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestGetMethods {
	@Test
	public void GetWeatherDetails() {
		//Base URL for the communication
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Specifications for the restful services mention headers and authentication details here
		RequestSpecification httprequest = RestAssured.given();
		
		//Get Request 
		Response response = httprequest.request(Method.GET, "Hyderabad");

		//Displaying the status code
		System.out.println("Status Code = "+response.getStatusCode());
		
		//Response Body
		ResponseBody response_body = response.body();
		System.out.println(response_body.asString());

		
		//Headers
		System.out.println("Content-Type : "+response.getHeader("Content-Type"));
		Headers all_headers = response.getHeaders();
		for(Header header : all_headers) {
			System.out.println(header.getName() + " : " + header.getValue());
		}
		
		
		//Json Path
		JsonPath json_path = response.jsonPath();
		String city = json_path.get("City");
		System.out.println("Json Path get city : "+city);
	}
}
