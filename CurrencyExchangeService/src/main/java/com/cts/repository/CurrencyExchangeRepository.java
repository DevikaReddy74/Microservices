package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);

}
