package testcases;


import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseAPIs.CreateCustomerAPI;
import baseAPIs.DeleteCustomerAPI;
import baseSetUp.BaseTest;
import io.restassured.response.Response;
import listeners.ExtentListeners;
import utilities.DataUtil;
import utilities.TestUtils;

public class ValidateDeletedCustomer extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateDeletedCustomer(Hashtable<String, String> data) {
		
		
		Response response = DeleteCustomerAPI.deleteCustomer(data);
		
		
		//checking status code
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		System.out.println("************-************");
		
		//to check if the given id is deleted
		String actualId = response.jsonPath().get("id").toString();
		System.out.println("Deleted id : "+actualId);
		Assert.assertEquals(actualId, data.get("id"),"IDs are not matching");
		System.out.println("*************************");
		
		//checking if a specific key is present
		Assert.assertTrue(TestUtils.hasKey(response.asString(), "object"), "Object key is not present");
		System.out.println("*************************");
		
		//retriving specific key values
		System.out.println("Value of object is : "+TestUtils.getKeyValue(response.asString(), "object"));
		System.out.println("Value of id is : "+TestUtils.getKeyValue(response.asString(), "id"));
		System.out.println("*************************");
		
	

	}
	
}
