package com.cts.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.model.CurrencyConversion;
import com.cts.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	// By Using rest template framework we are accessing the currency-exchange-service
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable double quantity) {
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
//		invoking the external service using rest template
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();

		Long id = currencyConversion.getId();
		double conversionMul = currencyConversion.getConversionMultiple();
		double total = quantity * conversionMul;

		return new CurrencyConversion(id, from, to, quantity, conversionMul, total);
	}

	// By Using OpenFeign rest client framework we are accessing the
	// currency-exchange-service
	// Feign makes it easy to invoke other microservice
	//To use Feign we need to first enable feign client at main method
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable double quantity) {

		CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);

		Long id = currencyConversion.getId();
		double conversionMul = currencyConversion.getConversionMultiple();
		double total = quantity * conversionMul;

		return new CurrencyConversion(id, from, to, quantity, conversionMul, total);
	}
}
