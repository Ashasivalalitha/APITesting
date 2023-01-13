package testcases;


import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseSetUp.BaseTest;
import io.restassured.response.Response;
import utilities.DataUtil;

public class VerifyStatus_withExcelData extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void verifyStatus_withExcelData(String name, String email, String description) {

		Response response = given().auth().basic(config.getProperty("apiKey"), "")
				.formParam("name", name)
				.formParam("email", email)
				.formParam("description", description)
				.log().all()
				.post(config.getProperty("endPoint_customer"));

		//response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println(response.statusCode());
		Assert.assertEquals(statusCode, 200);
	}



}
