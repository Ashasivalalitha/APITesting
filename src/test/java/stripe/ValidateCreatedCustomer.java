package stripe;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ValidateCreatedCustomer {

	public static void main(String[] args) {
		
		Response response = given().auth().basic("sk_test_51MNhKFKvF9o4bkwyVa7jzFUVh0tEz4DurJTXgiCZAuZEUsWdwEeW0nznGGAB2gazVHwdmYo3ZZoOciYM9BoswDaJ00GvSW3Mk2", "")
		.formParam("name", "test15")
		.formParam("email", "test15@gmail.com")
		.formParam("description", "test description")
		
		.formParam("address[city]", "city15")
		.formParam("address[line1]", "firstline15")
		.formParam("address[line2]", "secondline15")
		.formParam("preferred_locales[0]", "yes")
		
		.log().all()
		.post("https://api.stripe.com/v1/customers");
		
		response.prettyPrint();
		System.out.println(response.statusCode());
		JsonPath jsonPath = response.jsonPath();
	
		System.out.println(jsonPath.get("name").toString());
		System.out.println(jsonPath.get("address.line1").toString());
		System.out.println(jsonPath.get("preferred_locales[0]").toString());
		System.out.println(jsonPath.getMap("$").size());
		System.out.println(jsonPath.getMap("address").size());
		System.out.println(jsonPath.getList("preferred_locales"));
		System.out.println(jsonPath.getList("preferred_locales").size());
	}

}
