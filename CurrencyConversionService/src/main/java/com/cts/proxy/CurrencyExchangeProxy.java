package com.cts.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.model.CurrencyConversion;

//Just like we use a repository to talk to a JPA we need to create a feign proxy to talk to a external microservice
@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from,@PathVariable("to") String to); 

}
