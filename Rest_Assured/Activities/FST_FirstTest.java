package Examples;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.netty.util.AsciiString;
import io.restassured.RestAssured;
import io.restassured.response.Response;

// GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
//GET https://petstore.swagger.io/v2/pet/{petId}

public class FST_FirstTest {

	@Test
	public void getRequestWithQueryParam() {
		Response response = RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type", "application/json").queryParam("status", "sold").

				when().get("/findByStatus");

		//System.out.println(response.getBody().asString());
		//	System.out.println(response.getBody().asPrettyString());
		//String perstatus = response.then().extract().path("[0],['status']");
		//	System.out.println(perstatus);

		//Assert.assertEquals(perstatus, "sold");
		response.then().statusCode(200).body("[0].status", Matchers.equalTo("sold"));

	}

	
	//GET https://petstore.swagger.io/v2/pet/{petId}
	
	@Test
	public void getRequestWithPathParam() {
		// Send request, receive response, assert
		RestAssured.given().
			baseUri("https://petstore.swagger.io/v2/pet").
			header("Content-Type", "application/json"). // Define request type
			pathParam("petId", 12).
		when().
			get("/{petId}"). // get("/12")
		then().
			statusCode(200).
			body("status", Matchers.equalTo("available")).
			body("name", Matchers.equalTo("doggie"));
	}

}
