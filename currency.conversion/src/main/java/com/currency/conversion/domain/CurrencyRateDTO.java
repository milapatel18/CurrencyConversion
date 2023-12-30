package com.currency.conversion.domain;

import java.util.Date;

public class CurrencyRateDTO {
    private Date date;
    private Double jpy;

    public CurrencyRateDTO(Date date, Double rate) {
        this.date = date;
        this.jpy = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getJpy() {
        return jpy;
    }

    public void setJpy(Double jpy) {
        this.jpy = jpy;
    }
}
