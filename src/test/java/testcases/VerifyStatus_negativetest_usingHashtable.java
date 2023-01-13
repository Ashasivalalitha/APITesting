package testcases;


import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseSetUp.BaseTest;
import io.restassured.response.Response;
import utilities.DataUtil;

public class VerifyStatus_negativetest_usingHashtable extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void verifyStatus_negativetest_usingHashtable(Hashtable<String, String> data) {
		
		
		Response response = given().auth().basic(config.getProperty("invalidApiKey"), "")
				.formParam("name", data.get("name"))
				.formParam("email", data.get("email"))
				.formParam("description", data.get("description"))
		.log().all()
		.post(config.getProperty("endPoint_customer"));
		
		//response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println(response.statusCode());
		Assert.assertEquals(statusCode, 200);

	}
	
}
