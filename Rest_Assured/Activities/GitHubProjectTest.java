package project;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.MatcherConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubProjectTest {

	// ssh key to test with this
	String ssh_key = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIJzPm1N2QYr/we3BgEtThIKYUC9ahJvaZS+DndgFmM9P";

	// temp veriable to share this id
	int keyId;

	// declear response request specs

	ResponseSpecification responseSpec;
	RequestSpecification requestSpec;

	@BeforeClass
	public void setup() {

		requestSpec = new RequestSpecBuilder().setBaseUri("https://api.github.com/user/keys")
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "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")
				.addHeader("X-GitHub-Api-Version", "2022-11-28").build();

		// Initialization the respose specification

		responseSpec = new ResponseSpecBuilder().expectBody("title", Matchers.equalTo("TestKey"))
				.expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).build();

	}

	@Test(priority = 1)
	public void postRequestTest() {
		//request body as map
		
		HashMap<String , String> reqbody = new HashMap<>();
		reqbody.put("title", "TestKey");
		reqbody.put("Key", "ssh_key");
		
		//Send Requsest and save body
		Response response = RestAssured.given().spec(requestSpec).
		body(reqbody).
		when().post();
		
		//extract the id from response
		keyId = response.then().extract().path("id");
		
		//assertion
		response.then().statusCode(201).spec(responseSpec);
		
	}

	@Test(priority = 2)
	public void getRequestTest() {
		RestAssured.given().spec(requestSpec).pathParam("keyID", keyId).
		when().get("/{KeyId}").
		then().statusCode(200);		
	}
	
	@Test(priority =3)
	public void deletRequestTest() {
		RestAssured.given().spec(requestSpec).pathParam("keyID", keyId).
		when().get("/{KeyId}").
		then().statusCode(204);
		
	}
	
	
}
