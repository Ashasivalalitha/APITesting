package stripe;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreateCustomer_usingjsonFile {

	public static void main(String[] args) {
		
			
		Response response = given().contentType(ContentType.JSON).body(new File("./src/test/resources/testdata/data.json")).post("https://reqres.in/api/users");
		
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		
	}

}
