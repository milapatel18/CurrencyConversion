package com.currency.conversion.domain;

public class ConversionDTO {
    private String fromCurrency;
    private String toCurrency;
    private double sourceAmount;
    private double latestRate;

    private double totalAmount;

    public ConversionDTO(String fromCurrency, String toCurrency, double sourceAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.sourceAmount = sourceAmount;
    }

    public ConversionDTO(String fromCurrency, String toCurrency, double sourceAmount, double latestRate, double totalAmount) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.sourceAmount = sourceAmount;
        this.latestRate = latestRate;
        this.totalAmount = totalAmount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(double sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public double getLatestRate() {
        return latestRate;
    }

    public void setLatestRate(double latestRate) {
        this.latestRate = latestRate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
