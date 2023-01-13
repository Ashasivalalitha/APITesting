package testcases;


import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseAPIs.CreateCustomerAPI;
import baseAPIs.DeleteCustomerAPI;
import baseSetUp.BaseTest;
import io.restassured.response.Response;
import listeners.ExtentListeners;
import utilities.DataUtil;

public class TC03_DeleteCustomer extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void deleteCustomer(Hashtable<String, String> data) {
		
		
		Response response = DeleteCustomerAPI.deleteCustomer(data);
		//ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println(response.statusCode());
		Assert.assertEquals(statusCode, 200);

	}
	
}
