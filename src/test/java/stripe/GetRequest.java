package stripe;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetRequest {
	
	public static void main(String[] args) {
		
		Response response = given().auth().basic("sk_test_51MNhKFKvF9o4bkwyVa7jzFUVh0tEz4DurJTXgiCZAuZEUsWdwEeW0nznGGAB2gazVHwdmYo3ZZoOciYM9BoswDaJ00GvSW3Mk2", "")
							.get("https://api.stripe.com/v1/customers");
		
		//Way 1 :
		//given().contentType(ContentType.JSON);
		
		//Way 2 :
		//given().contentType("application/json");
		
		//Way 3 :
		//given().header("content-type", "application/json").auth().basic("sk_test_51MNhKFKvF9o4bkwyVa7jzFUVh0tEz4DurJTXgiCZAuZEUsWdwEeW0nznGGAB2gazVHwdmYo3ZZoOciYM9BoswDaJ00GvSW3Mk2", "");
		
		
		//for specific customer
		//Response response = given().header("Authorization","Bearer sk_test_51MNhKFKvF9o4bkwyVa7jzFUVh0tEz4DurJTXgiCZAuZEUsWdwEeW0nznGGAB2gazVHwdmYo3ZZoOciYM9BoswDaJ00GvSW3Mk2")
		           //.get("https://api.stripe.com/v1/customers/cus_N7zbCeEXKalhgV");
		
		
		
		//Below is with 1 and multiple params
		//Response response = given().params("limit",1).auth().basic("sk_test_51MNhKFKvF9o4bkwyVa7jzFUVh0tEz4DurJTXgiCZAuZEUsWdwEeW0nznGGAB2gazVHwdmYo3ZZoOciYM9BoswDaJ00GvSW3Mk2", "")
				//.get("https://api.stripe.com/v1/customers");
		//given().formParams("limit", 1).formParam("email", "asha_10002000@yahoo.com").auth().basic("sk_test_51MNhKFKvF9o4bkwyVa7jzFUVh0tEz4DurJTXgiCZAuZEUsWdwEeW0nznGGAB2gazVHwdmYo3ZZoOciYM9BoswDaJ00GvSW3Mk2", "")
		//.get("https://api.stripe.com/v1/customers");
		
		
		//sysout is not required for below
		response.prettyPrint();
		
		String response_string = response.asString();
		//System.out.println(response_string);
		
		int statusCode = response.statusCode();
		System.out.println("Status code : "+statusCode);
		
		
		
		
	}

}
