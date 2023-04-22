package com.Get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ffdd{

	public static void main(String[] args) {
		
		RequestSpecification reqSpec;
		//1. initialize the RestAssured
		
		reqSpec=RestAssured.given();
		
		//2.params, Header auth, body
		reqSpec=reqSpec.header("accept","application/json");
		
		//3.path param
		reqSpec=reqSpec.pathParam("list", "1");
		
		//4. method Type req Url
		
		Response response = reqSpec.get("https://reqres.in/api/unknown/{list}");
		
		//5.Get the StatusCode/ResCode
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		String asString = response.asString();
		System.out.println(asString);

}
	}
