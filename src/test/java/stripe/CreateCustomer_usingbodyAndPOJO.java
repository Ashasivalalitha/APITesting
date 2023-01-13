package stripe;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreateCustomer_usingbodyAndPOJO {

	public static void main(String[] args) {
		
		
		Users_forPOJO user = new Users_forPOJO("pojo2", "pojo2@gmail.com", "cross street2", "india");
		user.setPhone(4647545,8798798);
		
		Response response = given().contentType(ContentType.JSON).body(user).log().all().post("http://localhost:8081/api/users");
		
	
		response.prettyPrint();
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		
	}

}
