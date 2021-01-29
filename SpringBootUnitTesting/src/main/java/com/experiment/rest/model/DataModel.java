package com.experiment.rest.model;

public class DataModel 
{

	private int firstNumber;
	private int secondNumber;
	private int result;
	
	public DataModel(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getFirstNumber() {
		return firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}
}
