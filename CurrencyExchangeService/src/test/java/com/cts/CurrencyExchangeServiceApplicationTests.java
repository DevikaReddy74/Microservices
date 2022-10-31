package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.CurrencyExchange;
import com.cts.repository.CurrencyExchangeRepository;

@SpringBootTest
class CurrencyExchangeServiceApplicationTests {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@Test
	void contextLoads() {
		CurrencyExchange currencyExchange=currencyExchangeRepository.findByFromAndTo("USD", "INR");
		assertNotNull(currencyExchange);
		assertEquals(82, currencyExchange.getConversionMultiple());
		
	}

}
