package com.experiment.rest.service;

import org.springframework.stereotype.Service;

import com.experiment.rest.model.DataModel;

@Service
public class RestAssuredSampleService
{

	public void computeDifference(DataModel sumModel)
	{
		int result = sumModel.getFirstNumber() - sumModel.getSecondNumber();
		sumModel.setResult(result);		
	}

	public void computeSum(DataModel sumModel)
	{
		int result = sumModel.getFirstNumber() + sumModel.getSecondNumber();
		sumModel.setResult(result);
	}
}
