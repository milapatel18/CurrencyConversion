package com.currency.conversion.services;

import com.currency.conversion.domain.ConversionDTO;

import java.util.Map;

public interface CurrencyDetailsServices {
    public Map<String,String> getCurrencyNames();

    /**
     *Creates ConversionDTO response from the given source amount and currency conversion details
     * @param fromCurrency this is the source currency code, e.g. usd, jpy, eur, jpy
     * @param toCurrency this is the targeted currency code, e.g. usd, jpy, eur, jpy
     * @param sourceAmount requested amount to convert from given currency details
     * @return
     */
    public ConversionDTO getCurrencyConversion(String fromCurrency, String toCurrency, Double sourceAmount);

    /**
     * This method will return the current rate of the currency
     * @param fromCurrency this is the source currency code, e.g. usd, jpy, eur, jpy
     * @param toCurrency this is the targeted currency code, e.g. usd, jpy, eur, jpy
     * @return value is float as a current currency rate
     */
    public double getCurrentRate(String fromCurrency, String toCurrency);

}
