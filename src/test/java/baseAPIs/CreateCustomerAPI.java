package baseAPIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import baseSetUp.BaseTest;
import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest {
	
	public static Response createCustomer_positive(Hashtable<String, String> data) {

		Response response = given().auth().basic(config.getProperty("apiKey"), "")
				.formParam("name", data.get("name"))
				.formParam("email", data.get("email"))
				.formParam("description", data.get("description"))
				.log().all()
				.post(config.getProperty("endPoint_customer"));
		
		return response;

	}
	
	
	public static Response createCustomer_negative(Hashtable<String, String> data) {

		Response response = given().auth().basic(config.getProperty("invalidApiKey"), "")
				.formParam("name", data.get("name"))
				.formParam("email", data.get("email"))
				.formParam("description", data.get("description"))
				.log().all()
				.post(config.getProperty("endPoint_customer"));
		
		return response;

	}


}
