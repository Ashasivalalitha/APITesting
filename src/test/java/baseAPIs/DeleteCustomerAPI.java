package baseAPIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import baseSetUp.BaseTest;
import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest {
	
	public static Response deleteCustomer(Hashtable<String, String> data) {

		Response response = given().auth().basic(config.getProperty("apiKey"), "")
				.delete(config.getProperty("endPoint_customer")+"/"+data.get("id"));
		
		return response;

	}


}
