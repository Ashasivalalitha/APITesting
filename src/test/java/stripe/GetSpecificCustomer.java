package stripe;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;



public class GetSpecificCustomer {

	public static void main(String[] args) {
		
		Response response = given().header("Authorization","Bearer sk_test_51MNhKFKvF9o4bkwyVa7jzFUVh0tEz4DurJTXgiCZAuZEUsWdwEeW0nznGGAB2gazVHwdmYo3ZZoOciYM9BoswDaJ00GvSW3Mk2")
				//.get("https://api.stripe.com/v1/customers/cus_N7zbCeEXKalhgV");
				.get("https://api.stripe.com/v1/customers/cus_N99Gd6XPCETGjd");
		
		response.prettyPrint();
		
		System.out.println(response.statusCode());

	}

}
