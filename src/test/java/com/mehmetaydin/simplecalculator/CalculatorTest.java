package com.mehmetaydin.simplecalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mehmetaydin.simplecalculator.model.Calculator;

public class CalculatorTest {
	
	@Test
	public void AdditionPositivePositive() {
		Calculator calc = new Calculator();
		double result = calc.addTwoNumbers(3, 2);
		assertEquals(5.0, result, 0);
	}
	
	@Test
	public void AdditionPositiveNegative() {
		Calculator calc = new Calculator();
		double result = calc.addTwoNumbers(10, -4);
		assertEquals(6.0, result, 0);
	}
	
	@Test
	public void AdditionNegativePositive() {
		Calculator calc = new Calculator();
		double result = calc.addTwoNumbers(-3, 2);
		assertEquals(-1.0, result, 0);
	}
	
	@Test
	public void AdditionNegativeNegative() {
		Calculator calc = new Calculator();
		double result = calc.addTwoNumbers(-5, -7);
		assertEquals(-12.0, result, 0);
	}
	
	@Test
	public void SubtractionPositivePositive() {
		Calculator calc = new Calculator();
		double result = calc.subTwoNumbers(3, 2);
		assertEquals(1.0, result, 0);
	}
	
	@Test
	public void SubtractionPositiveNegative() {
		Calculator calc = new Calculator();
		double result = calc.subTwoNumbers(10, -4);
		assertEquals(14.0, result, 0);
	}
	
	@Test
	public void SubtractionNegativePositive() {
		Calculator calc = new Calculator();
		double result = calc.subTwoNumbers(-10, 2);
		assertEquals(-12.0, result, 0);
	}
	
	@Test
	public void SubtractionNegativeNegative() {
		Calculator calc = new Calculator();
		double result = calc.subTwoNumbers(-5, -7);
		assertEquals(2.0, result, 0);
	}
	
	@Test
	public void MultiplicationPositivePositive() {
		Calculator calc = new Calculator();
		double result = calc.mulTwoNumbers(8, 2);
		assertEquals(16.0, result, 0);
	}
	
	@Test
	public void MultiplicationPositiveNegative() {
		Calculator calc = new Calculator();
		double result = calc.mulTwoNumbers(10, -2);
		assertEquals(-20, result, 0);
	}
	
	@Test
	public void MultiplicationNegativePositive() {
		Calculator calc = new Calculator();
		double result = calc.mulTwoNumbers(-10, 4);
		assertEquals(-40, result, 0);
	}
	
	@Test
	public void MultiplicationNegativeNegative() {
		Calculator calc = new Calculator();
		double result = calc.mulTwoNumbers(-5, -7);
		assertEquals(35.0, result, 0);
	}
	
	@Test
	public void divisionPositivePositive() {
		Calculator calc = new Calculator();
		double result = calc.divTwoNumbers(8, 2);
		assertEquals(4.0, result, 0);
	}
	
	@Test
	public void divisionPositiveNegative() {
		Calculator calc = new Calculator();
		double result = calc.divTwoNumbers(10, -2);
		assertEquals(-5, result, 0);
	}
	
	@Test
	public void divisionNegativePositive() {
		Calculator calc = new Calculator();
		double result = calc.divTwoNumbers(-10, 4);
		assertEquals(-2.5, result, 0);
	}
	
	@Test
	public void divisionNegativeNegative() {
		Calculator calc = new Calculator();
		double result = calc.divTwoNumbers(-24, -8);
		assertEquals(3, result, 0);
	}
}
