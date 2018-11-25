package com.mehmetaydin.simplecalculator.model;

import java.util.Map;
	
public class CalculatorJsonResponse {
	private double result;
	private boolean validated;
	private Map<String, String> errorMessages;
	
	public void setResult(Double calculatorResult) {
		this.result = calculatorResult;
	}
	public void setValidate(Boolean isValid) {
		this.validated = isValid;
	}
	
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	public double getResult() {
		return this.result;
	}
	
	public boolean getValidated() {
		return this.validated;
	}
	
	public Map<String, String> getErrorMessages(){
		return this.errorMessages;
	}
	

}
