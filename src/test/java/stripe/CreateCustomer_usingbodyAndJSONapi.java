package stripe;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreateCustomer_usingbodyAndJSONapi {

	public static void main(String[] args) {
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("name", "morpheus");
		jsonObject.put("email", "test6@gmail.com");
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(1234343);
		jsonArray.put(24433434);
		jsonObject.put("phone_no", jsonArray);
		
		JSONObject address = new JSONObject();
		address.put("street", "st1");
		address.put("country", "india");
		jsonObject.put("address", address);
		
		
		
		Response response = given().contentType(ContentType.JSON).body(jsonObject.toString()).log().all().post("http://localhost:8081/api/users");
		
	
		response.prettyPrint();
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		
	}

}
