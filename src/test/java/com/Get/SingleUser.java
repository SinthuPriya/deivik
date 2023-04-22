package com.Get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SingleUser {
	public static void main(String[] args) {
		RequestSpecification reqSpec;
		
		//1. initilize the RestAssured
		
		reqSpec=RestAssured.given();
		reqSpec=reqSpec.header("accept","application/json");
		reqSpec=reqSpec.pathParam("id","2");
		Response response =reqSpec.get("https://reqres.in/api/users/{id}");
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		String asString = response.asString();
		System.out.println(asString);
		
	}

}
