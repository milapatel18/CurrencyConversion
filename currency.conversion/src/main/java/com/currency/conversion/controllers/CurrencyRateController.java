package com.currency.conversion.controllers;

import com.currency.conversion.domain.ConversionDTO;
import com.currency.conversion.services.CurrencyDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyRateController {

    @Autowired
    private CurrencyDetailsServices currencyDetailsServices;

    @GetMapping("/{fromCurrency}/{toCurrency}/{sourceAmount}")
    public ConversionDTO getConversion(@PathVariable("fromCurrency") String fromCurrency,
                                       @PathVariable("toCurrency") String toCurrency,
                                       @PathVariable("sourceAmount") String sourceAmount, Model model) {
        return currencyDetailsServices.getCurrencyConversion(fromCurrency, toCurrency,
                Double.parseDouble(sourceAmount));
    }
}
