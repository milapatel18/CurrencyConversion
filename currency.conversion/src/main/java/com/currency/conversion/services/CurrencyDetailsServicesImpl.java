package com.currency.conversion.services;

import com.currency.conversion.domain.ConversionDTO;
import com.currency.conversion.domain.CurrencyRateDTO;
import com.currency.conversion.utils.CurrencyAPI;
import com.currency.conversion.utils.CurrencyEnum;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class CurrencyDetailsServicesImpl implements CurrencyDetailsServices{
    @Override
    public Map<String, String> getCurrencyNames() {
        return null;
    }

    @Override
    public ConversionDTO getCurrencyConversion(String fromCurrency, String toCurrency, Double sourceAmount) {
        ConversionDTO conversionDTO=new ConversionDTO(fromCurrency,toCurrency,sourceAmount);
        conversionDTO.setLatestRate(this.getCurrentRate(fromCurrency,toCurrency));
        conversionDTO.setTotalAmount(sourceAmount*conversionDTO.getLatestRate());
        CurrencyEnum ce = CurrencyEnum.findByAbbr(toCurrency);
        if (ce.getCurrencyDecimals() < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(conversionDTO.getTotalAmount());
        bd = bd.setScale(ce.getCurrencyDecimals(), RoundingMode.UP);
        conversionDTO.setTotalAmount(bd.doubleValue());
        return conversionDTO;
    }

    @Override
    public double getCurrentRate(String fromCurrency, String toCurrency) {
        String uri = CurrencyAPI.CONVERSION_URL+fromCurrency+"/"+toCurrency+CurrencyAPI.CONVERSION_SUFFIX;
        RestTemplate restTemplate = new RestTemplate();

        String resp = restTemplate.getForObject(uri, String.class);
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map <String, Object> map = springParser.parseMap(resp);
        //System.out.println(map.get(toCurrency));
        CurrencyEnum ce = CurrencyEnum.findByAbbr(toCurrency);
        if (ce.getCurrencyDecimals() < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf((double)map.get(toCurrency));
        bd = bd.setScale(ce.getCurrencyDecimals(), RoundingMode.UP);
        return bd.doubleValue();
    }
}
