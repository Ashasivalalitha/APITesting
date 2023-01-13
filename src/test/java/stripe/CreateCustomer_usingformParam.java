package stripe;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;


public class CreateCustomer_usingformParam {

	public static void main(String[] args) {
		
		Response response = given().auth().basic("sk_test_51MNhKFKvF9o4bkwyVa7jzFUVh0tEz4DurJTXgiCZAuZEUsWdwEeW0nznGGAB2gazVHwdmYo3ZZoOciYM9BoswDaJ00GvSW3Mk2", "")
		.formParam("name", "test12")
		.formParam("email", "test12@gmail.com")
		.formParam("description", "test12 description")
		
		.formParam("address[city]", "city12")
		.formParam("address[line1]", "firstline12")
		.formParam("address[line2]", "secondline12")
		
		.formParam("preferred_locales[0]", "yes")
				
		.log().all()
		.post("https://api.stripe.com/v1/customers");
		
		response.prettyPrint();
		//System.out.println(response.asString());
		System.out.println(response.statusCode());
	}

}
