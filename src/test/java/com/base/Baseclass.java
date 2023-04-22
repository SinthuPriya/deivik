package com.base;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	
	RequestSpecification reqSpec;
	Response response;
	
	public void basicAuth(String userName,String password) {
		reqSpec=reqSpec.auth().preemptive().basic(userName,password);
	}
	public void addHeader(String key, String Value) {
		reqSpec = RestAssured.given().header(key,Value);
	}
	public void addHeaders(Headers headers) {
		reqSpec=RestAssured.given().headers(headers);
	}
	public void addPathParam(String Key, String Value) {
		reqSpec = reqSpec.pathParam(Key, Value);
	}
	public void addqueryParam(String Key, String Value) {
		reqSpec=reqSpec.queryParam(Key, Value);
	}
	public void addBody(Object body) {
		reqSpec=reqSpec.body(body);
	}
	public String getMessage() {
		return getMessage();
	}
	public Response requestType(String type,String endpoint) {
		
		switch(type) {
		case "GET":
			response=reqSpec.get(endpoint);
			break;
			
		case "POST":
			response=reqSpec.log().all().post(endpoint);
			break;
		case "DELETE":
			response=reqSpec.delete(endpoint);
			break;
			default:
				break;
			
					}
		return response;
		
	}
	
	public Response requestTypelogAll(String type, String endpoint) {
		switch(type) {
		case "GET":
			response=reqSpec.log().all().get(endpoint);
			break;
		case "POST":
			response=reqSpec.log().all().post(endpoint);
			break;
		case "PUT":
			response=reqSpec.log().all().put(endpoint);
			break;
			default:
				break;
		}
		return response;
		
	}
	public int getstatusCode(Response response) {
		int statusCode=response.getStatusCode();
		return statusCode;
		
	}
	public String getResBody(Response response) {
		String asString = response.asString();
		return asString;
				
	}
	public String getResBodyAsPretty(Response response) {
		String asPrettyString = response.asString();
		return asPrettyString;
		
	}

}
