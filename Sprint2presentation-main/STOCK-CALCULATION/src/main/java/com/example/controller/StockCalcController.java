package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.StockCalService;

@RestController
@RequestMapping("/stockcalc")
public class StockCalcController {
	@Autowired
	private StockCalService stockService;
	@GetMapping("/{quantity}/{price}")
	public Double claculateStockAmount(@PathVariable Double quantity, @PathVariable Double price) {
		return stockService.claculateStockAmount(quantity, price);
	}
	

}
