package stripe;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreateCustomer_usingbodyAndMap {

	public static void main(String[] args) {
		
		
		HashMap<String, String> map = new HashMap<String, String>();
		/*map.put("name", "test5");
		map.put("email", "test5@gmail.com");
		map.put("description", "test5 description");
		*/
		map.put("name", "morpheus");
		map.put("email", "test5@gmail.com");
		
		//System.out.println(map);
		
		
			
		String array_string = "{\"name\":\"test5\",\"email\":\"test5@gmail.com\",\"description\":\"test5 description\"}";
		
		Response response = given().contentType(ContentType.JSON).body(map).post("https://reqres.in/api/users");
		
		
		//Response response = given().auth().basic("sk_test_51MNhKFKvF9o4bkwyVa7jzFUVh0tEz4DurJTXgiCZAuZEUsWdwEeW0nznGGAB2gazVHwdmYo3ZZoOciYM9BoswDaJ00GvSW3Mk2", "")	
		//.contentType(ContentType.JSON)
				//.contentType("application/x-www-form-urlencoded")
				//.header("content-type", "application/x-www-form-urlencoded")
			//	.header("content-type", "json")
				//.body("{ \"name\" : \"dummy\" }")
				//.body("\"name\":\"dummy\"")
			//	.body(map)
				//.body(array_string)
			//	.post("https://api.stripe.com/v1/customers");
		
		//example
		//given().body("{ \"message\" : \"hello world\"}").when().post("/json").then().assertThat().body(equalTo("hello world"));
		 
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		
	}

}
