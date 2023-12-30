package com.currency.conversion.controllers;

import com.currency.conversion.services.CurrencyDetailsServices;
import com.currency.conversion.utils.CurrencyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *This is a base controller for main UI Page
 */
@Controller
public class HomeMVCController {

    @Autowired
    private CurrencyDetailsServices currencyDetailsServices;

    @Value("${spring.application.name}")
    String appName;

    /**
     * Response with front page and required currencies
     * @param model
     * @return
     */
    @GetMapping("/hello")
    public String homePage(Model model) {
        //model.addAttribute("appName", appName);
        model.addAttribute("appName", "Currency Conversion Application");
        model.addAttribute("currencyMap", CurrencyEnum.getCurrencyMap());
        return "home";
    }
}