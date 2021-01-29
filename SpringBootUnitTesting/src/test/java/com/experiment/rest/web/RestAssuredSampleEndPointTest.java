package com.experiment.rest.web;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

@RunWith(SpringRunner.class)
public class RestAssuredSampleEndPointTest
{

	@BeforeAll
	public static void setUpBeforeClass() throws Exception
	{
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 6347;
		RestAssured.basePath = "/restAssuredSample";
	}

	@Test
	public void testComputeDifference()
	{
		Response response = RestAssured
		.given()
		.when().get("/computeDifference/8/3");
		
		Assert.assertEquals(200, response.getStatusCode());

		response.then()
		.contentType(ContentType.JSON)
		.body("firstNumber", equalTo(8))
		.body("secondNumber", equalTo(3))
		.body("result", equalTo(5));
	}

	@Test
	public void testComputeSum()
	{
	
	}

}
