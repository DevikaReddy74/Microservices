package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.CurrencyExchange;
import com.cts.repository.CurrencyExchangeRepository;

//@Controller and @responseBody
//we can send and request the object data in JSON or XML format
@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}/id/{id}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to,@PathVariable Long id) {
		
		//CurrencyExchange currencyExchange = new CurrencyExchange(1000L,from,to,BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange=currencyExchangeRepository.findById(id).get();
		if(currencyExchange==null) {
			throw new RuntimeException("Unable to find data from "+from+" and to "+to);
		}

		return currencyExchange;
	}

}