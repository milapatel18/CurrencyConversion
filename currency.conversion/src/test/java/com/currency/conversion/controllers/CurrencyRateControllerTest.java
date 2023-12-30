package com.currency.conversion.controllers;

import com.currency.conversion.Application;
import com.currency.conversion.services.CurrencyDetailsServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= Application.class)
@WebMvcTest(CurrencyRateController.class)
public class CurrencyRateControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private CurrencyDetailsServices currencyDetailsServices;

    @InjectMocks
    private CurrencyRateController currencyRateController;

//    @Test
//    public void testGetConversion() {
//        // Mock data
//        String fromCurrency = "USD";
//        String toCurrency = "EUR";
//        String sourceAmount = "100.0";
//
//        ConversionDTO mockConversionDTO = new ConversionDTO();
//        mockConversionDTO.setFromCurrency(fromCurrency);
//        mockConversionDTO.setToCurrency(toCurrency);
//        mockConversionDTO.setSourceAmount(Double.parseDouble(sourceAmount));
//        mockConversionDTO.setLatestRate(120.0); // Mocked conversion result
//
//        // Mock the service method to return the mockConversionDTO
//        Mockito.when(currencyDetailsServices.getCurrencyConversion(fromCurrency, toCurrency,
//                Double.parseDouble(sourceAmount))).thenReturn(mockConversionDTO);
//
//        // Call the controller method
//        ConversionDTO result = currencyRateController.getConversion(fromCurrency, toCurrency, sourceAmount, Mockito.mock(Model.class));
//
//        // Verify that the service method was called with the correct arguments
//        Mockito.verify(currencyDetailsServices, Mockito.times(1))
//                .getCurrencyConversion(fromCurrency, toCurrency, Double.parseDouble(sourceAmount));
//
//        // Verify that the result matches the expected mockConversionDTO
//        assertEquals(mockConversionDTO, result);
//    }

    @Test
    public void testGetConversionAPI() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders
                        .get("/currency/usd/inr/1000")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.fromCurrency").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalAmount").isNotEmpty());
    }

    @Test
    public void testAddEmployee()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
    }
}