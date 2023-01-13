package testcases;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseAPIs.CreateCustomerAPI;
import baseSetUp.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import listeners.ExtentListeners;
import utilities.DataUtil;

public class TC01_VerifyStatus_positivetest_usingHashtable extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void verifyStatus_positivetest_usingHashtable(Hashtable<String, String> data) {

		Response response = CreateCustomerAPI.createCustomer_positive(data);
		ExtentListeners.testReport.get().info(data.toString());
		//response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println(response.statusCode());
		Assert.assertEquals(statusCode, 200);
	}



}
