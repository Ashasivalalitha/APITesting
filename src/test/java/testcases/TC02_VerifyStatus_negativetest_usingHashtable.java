package testcases;


import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseAPIs.CreateCustomerAPI;
import baseSetUp.BaseTest;
import io.restassured.response.Response;
import listeners.ExtentListeners;
import utilities.DataUtil;

public class TC02_VerifyStatus_negativetest_usingHashtable extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void verifyStatus_negativetest_usingHashtable(Hashtable<String, String> data) {
		
		
		Response response = CreateCustomerAPI.createCustomer_negative(data);
		ExtentListeners.testReport.get().info(data.toString());
		//response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println(response.statusCode());
		Assert.assertEquals(statusCode, 200);

	}
	
}
