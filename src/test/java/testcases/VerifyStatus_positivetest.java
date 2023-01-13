package testcases;


import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseSetUp.BaseTest;
import io.restassured.response.Response;

public class VerifyStatus_positivetest extends BaseTest {

	@Test
	public void verifyStatus() {
		
		Response response = given().auth().basic(config.getProperty("apiKey"), "")
		.formParam("name", "test20")
		.formParam("email", "test20@gmail.com")
		.formParam("description", "This is a test description")
		.log().all()
		.post(config.getProperty("endPoint_customer"));
		
		//response.prettyPrint();
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);

	}
	
}
