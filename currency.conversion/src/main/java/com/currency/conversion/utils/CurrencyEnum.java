package com.currency.conversion.utils;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum CurrencyEnum {

    INR("inr","Indian Rupee",2),
    USD("usd","USD Dollars", 2),
    EUR("eur", "EURO", 2),
    JPY("jpy","Japanese Yen",0);
    private final String currencyCode;
    private final String currencyName;
    private final int currencyDecimals;

    CurrencyEnum(String currencyCode, String currencyName, int currencyDecimals) {
        this.currencyCode=currencyCode;
        this.currencyName=currencyName;
        this.currencyDecimals=currencyDecimals;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public int getCurrencyDecimals() {
        return currencyDecimals;
    }

    public static CurrencyEnum findByAbbr(String abbr){
        for(CurrencyEnum v : values()){
            if( v.getCurrencyCode().equals(abbr)){
                return v;
            }
        }
        return null;
    }
    public static Map<String, String> getCurrencyMap(){
        Map<String, String> currencyMap = Arrays.stream(CurrencyEnum.values()).collect(
                Collectors.toMap(CurrencyEnum::getCurrencyCode, CurrencyEnum::getCurrencyName));
        return currencyMap;
    }
}
