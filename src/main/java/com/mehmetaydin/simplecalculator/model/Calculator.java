package com.mehmetaydin.simplecalculator.model;

import javax.validation.constraints.NotNull;

public class Calculator {
	
	@NotNull(message = "First number is not valid")
	private double firstNumber;
	@NotNull(message = "Second number is not valid")
	private double secondNumber;
	@NotNull(message = "Operation is not valid. Please use addition, subtraction, multpilication, division")
	private String operation;
	
	public double getFirstNumber() {
		return firstNumber;
	}
	
	public void setFirstNumber(double firstNumber) {
		this.firstNumber = firstNumber;
	}
	
	public double getSecondNumber() {
		return secondNumber;
	}
	
	public void setSecondNumber(double secondNumber) {
		this.secondNumber = secondNumber;
	}
	
	public String getOperation() {
		return this.operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public double calculateWithOperationName() {
		switch (this.operation) {
		case "addition":
			return this.addTwoNumbers(firstNumber, secondNumber);
		case "subtraction":
			return this.subTwoNumbers(firstNumber, secondNumber);
			
		case "multiplication":
			return this.mulTwoNumbers(firstNumber, secondNumber);
		case "division":
			return this.divTwoNumbers(firstNumber, secondNumber);
		}
		return 0.0;
	}
	
	public double addTwoNumbers(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}
	
	public double subTwoNumbers(double firstNumber, double secondNumber) {
		return firstNumber - secondNumber;
	}
	
	public double mulTwoNumbers(double firstNumber, double secondNumber) {
		return firstNumber * secondNumber;
	}
	
	public double divTwoNumbers(double firstNumber, double secondNumber) {
		return firstNumber / secondNumber;
	}
	
	
}
