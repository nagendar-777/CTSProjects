package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Stock;
import com.example.entity.StockCalculation;
import com.example.entity.StockDetails;
import com.example.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
	private StockService stockService;
    
    @PostMapping("/")
	public Stock saveUser(@RequestBody Stock stock) {
		return stockService.saveUser(stock);
	}
    @GetMapping("/{userId}")
    public List<Stock> getStocksByUserId(@PathVariable Long userId){
		return stockService.getStocksByUserId(userId);
	}
    @GetMapping("/{companyName}/{quantity}")
    public StockCalculation calculateAmount(@PathVariable String companyName,@PathVariable Long quantity){
		return stockService.calculateAmount(companyName,quantity);
	}
    @GetMapping("/stockdetails")
    public List<StockDetails> getStockDetails(){
		return stockService.getStockDetails();
	}
}
