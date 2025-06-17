package com.example.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StockCalService {
	
public Double claculateStockAmount( Double quantity,  Double price) {
	Double amount=quantity*price;
	return round(amount,2);
	
		
	}
public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
}
