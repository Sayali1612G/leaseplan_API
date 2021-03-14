package stepdefinations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.util.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Apitest {
	
	
	public static Response response;
	public static RequestSpecification httpRequest;
	public static String responseBody;
	InputStream inputStream;
	
	@Given("User will provide baseURI {string}")
	public void user_will_provide_base_uri(String URI) throws IOException {
		
		
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
					} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}
		
			String token = prop.getProperty("token");
			RestAssured.baseURI = URI;
			httpRequest = RestAssured.given();
			response = httpRequest.request(Method.GET, token);

			} catch (Exception e) {
				System.out.println("Exception: " + e);
			} finally {
				inputStream.close();
			}
			}
	
	@When("User will get a {int} status code")
	public void user_will_get_a_status_code(Integer int1) {
		
		int statusCode = response.getStatusCode();
		assertEquals(200,statusCode);
		 		
	}

	@Then("User will verify content of weburi {string}")
	public void user_will_verify_content_of_weburi(String string) {
		
		System.out.println(response.header("Content-Type"));
		assertTrue((response.header("Content-Type")).contains(string));
	}


}
