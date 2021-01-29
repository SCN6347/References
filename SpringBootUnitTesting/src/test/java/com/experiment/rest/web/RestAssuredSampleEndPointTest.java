package com.experiment.rest.web;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

public class RestAssuredSampleEndPointTest
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 6347;
		RestAssured.basePath = "/restAssuredSample";
	}

	@Test
	public void testComputeDifference()
	{
		RestAssured
		.given()
		.when().get("/computeDifference/3/8")
		.then()
		.statusCode(200)
		.and()
		.contentType(ContentType.JSON)
		.body("firstNumber", equalTo(3))
		.body("secondNumber", equalTo(3))
		.body("result", equalTo(3));
	}

	@Test
	public void testComputeSum()
	{
	
	}

}
