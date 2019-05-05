package getRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {

	//JUnit
	public static void main(String[] args)	{

		//TestNG 
		//@Test
//	public void testResponseCode(){
		Response resp = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=Little Rock,usa&appid=b6907d289e10d714a6e88b30761fae22");
		int code = resp.getStatusCode();
		System.out.println("Status code = "+code);
 	
	}

}
