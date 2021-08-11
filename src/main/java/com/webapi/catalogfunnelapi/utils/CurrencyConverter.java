package com.webapi.catalogfunnelapi.utils;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

@Component
public class CurrencyConverter {

    public String formatStringToEuro(String stringValue){

        double doubleCurr = Double.parseDouble(stringValue);
        Locale eur = new Locale("pt", "PT");
        NumberFormat euroFormat = NumberFormat.getCurrencyInstance(eur);
        String converted = euroFormat.format(doubleCurr);
        return converted;

    }

}
