package postRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
//Code to make simple GET requet on weather Restful webservice
public class SimplePostTest {

	@BeforeTest
	public void prereq(){
		System.out.println("****************Test Begins**********");
	}
	@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");

		requestParams.put("Email",  "sample2ee26d9@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
	
	public void RegistrationSuccessful_NegataiveTest()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");	
		requestParams.put("Email",  "sample2ee26d9@gmail.com");

		request.body(requestParams.toJSONString());
		Response response = request.get("/register");

		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.body().asString());
	}
	
}