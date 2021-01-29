package com.experiment.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.experiment.rest.model.DataModel;
import com.experiment.rest.service.RestAssuredSampleService;

@RestController
@RequestMapping(value= "/restAssuredSample")
public class RestAssuredSampleEndPoint
{
	
	private RestAssuredSampleService sampleService;
	
	@Autowired
	public RestAssuredSampleEndPoint(RestAssuredSampleService sampleService)
	{
		this.sampleService = sampleService;
	}

	@RequestMapping("/computeDifference/{firstNumber}/{secondNumber}")
	public DataModel computeDifference(@PathVariable int firstNumber, @PathVariable int secondNumber)
	{
		DataModel sumModel = new DataModel(firstNumber, secondNumber);
		sampleService.computeDifference(sumModel);
		return sumModel;
	}
	
	@RequestMapping("/computeSum/{firstNumber}/{secondNumber}")
	public DataModel computeSum(@PathVariable int firstNumber, @PathVariable int secondNumber)
	{
		DataModel sumModel = new DataModel(firstNumber, secondNumber);
		sampleService.computeSum(sumModel);
		return sumModel;
	}
}
