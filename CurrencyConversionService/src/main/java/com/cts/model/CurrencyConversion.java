package com.cts.model;

public class CurrencyConversion {

	private Long id;
	private String from;
	private String to;
	private double quantity;
	private double conversionMultiple;
	private double totalAmount;

	public CurrencyConversion() {

	}

	public CurrencyConversion(Long id, String from, String to, double quantity, double conversionMultiple,
			double totalAmount) {

		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(double conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
