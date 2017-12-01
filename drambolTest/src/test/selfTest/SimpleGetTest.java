import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {

	@BeforeClass
	public void setProxy() {
		System.setProperty("http.proxyHost", "10.23.20.143");
		System.setProperty("http.proxyPort", "8080");
	}

	@Test
	public void GetWeatherDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the
		// method URL.
		// This will return the Response from the server. Store the response in
		// a variable.
		Response response = httpRequest.get("/Hyderabad");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		Assert.assertEquals(responseBody.contains("Hyderabad"), true, "Response body contains Hyderabad");
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String city = jsonPathEvaluator.get("City");
		// Let us print the city variable to see what we got
		System.out.println("City received from Response " + city);

		int statusCode = response.getStatusCode();
		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode, 200, "Correct status code returned");

		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");
		
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type value: " + contentType);
		Assert.assertEquals(contentType, "application/json");
	 
		// Reader header of a give name. In this line we will get
		// Header named Server
		String serverType =  response.header("Server");
		System.out.println("Server value: " + serverType);
		Assert.assertEquals(serverType, "nginx/1.12.2");
	 
		// Reader header of a give name. In this line we will get
		// Header named Content-Encoding
		String contentEncoding = response.header("Content-Encoding");
		System.out.println("Content-Encoding: " + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
//		Headers allHeaders = response.headers();
//		for(Header header : allHeaders)
//		{
//			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
//		}

	}

}
