package stripe;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreateCustomer_usingbodyAndComplexMap {

	public static void main(String[] args) {
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("name", "morpheus");
		map.put("email", "test6@gmail.com");
		
		ArrayList<Integer> phone = new ArrayList<Integer>();
		phone.add(1234343);
		phone.add(24433434);
		map.put("phone_no", phone);
		
		HashMap<String, Object> address = new HashMap<String, Object>();
		address.put("street", "st1");
		address.put("country", "india");
		map.put("address", address);
		
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			map1.put("degree", "be");
			map1.put("score", "80");
			HashMap<String, Object> map2 = new HashMap<String, Object>();
			map2.put("degree", "me");
			map2.put("score", "90");
		list.add(map1);
		list.add(map2);
		map.put("education", list);	
		
		Response response = given().contentType(ContentType.JSON).body(map).log().all().post("http://localhost:8081/api/users");
		
	
		response.prettyPrint();
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		
	}

}
