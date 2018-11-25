package com.mehmetaydin.simplecalculator.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mehmetaydin.simplecalculator.model.Calculator;
import com.mehmetaydin.simplecalculator.model.CalculatorJsonResponse;

@Controller
public class HomeController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "calculate",method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody public CalculatorJsonResponse calculate(@ModelAttribute @Valid Calculator calculator, BindingResult bindingResult, Errors errors, Model model) {
		CalculatorJsonResponse response = new CalculatorJsonResponse();
		Boolean isValid = !bindingResult.hasErrors();
		if(isValid) {
			
			response.setValidate(true);
			response.setResult(calculator.calculateWithOperationName());
			response.setErrorMessages(null);
			return response;
			
		}
		else {
			
			Map<String, String> errorMap = new HashMap<String, String>();
			if(errors.hasFieldErrors("firstNumber")) {
				errorMap.put("firstNumber", "* 1. sayı tipi geçersizdir.");
			}
			if(errors.hasFieldErrors("secondNumber")) {
				errorMap.put("secondNumber", "* 2. sayı tipi geçersizdir.");
			}
			if(errors.hasFieldErrors("operation")) {
				errorMap.put("operation", "* İşlem tipi geçersizdir. Kullanılabilir işemler addition, subtraction, multiplication, division");
			}
			response.setValidate(false);
			response.setErrorMessages(errorMap);
			return response;
			
		}
	}

}
