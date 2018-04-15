package rest_assured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class NewTest {
	  @Test
	  public void GetWeatherDetails() {
		  //Base uri
		  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		  //Here we can add headers and authentication
		  RequestSpecification httpRequest = RestAssured.given();
		  
		  //ask httprequest to request
		  Response response = httpRequest.request(Method.GET, "/Hyderabad");
		  
		  String responseBody = response.getBody().asString();
		  System.out.println("Response Body is => "+ responseBody);
		  
		  //Assert status code
		  int statuscode = response.getStatusCode();
		  System.out.println("Status Code : "+ statuscode);
		  Assert.assertEquals(statuscode, 200);
		  
		  //Assert status line
		  String statusline = response.getStatusLine();
		  System.out.println("Status Line : "+ statusline);
		  Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		  
		  //Header Information
		  String contentType = response.header("Content-Type");
		  System.out.println("Content-Type : "+ contentType);
		  
		  String server = response.header("Server");
		  System.out.println("Server Type : "+ server);
		  
		  String content_encoding = response.header("Content-Encoding");
		  System.out.println("Content-Encoding : "+ content_encoding);
		  
		  
		  //All headers
		  Headers all_headers = response.getHeaders();
		  for(Header header : all_headers) {
			  System.out.println("Key : "+header.getName()+" Value :"+header.getValue());
		  }
		  
		  
		  //Response Body
		  ResponseBody rbody = response.getBody();
		  String response_body_string = rbody.asString();
		  Assert.assertEquals(response_body_string.contains("Hyderabad"), true, "Response body doesn't contains Hyderabad");
		  
		  JsonPath jsonpath = response.jsonPath();
		  String city = jsonpath.get("City");
		  Assert.assertEquals(city, "Hyderabad", "City must be Hyderabad");
		  
	  }
}