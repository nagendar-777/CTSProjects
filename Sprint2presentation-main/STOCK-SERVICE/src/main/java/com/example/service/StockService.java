package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Stock;
import com.example.entity.StockCalculation;
import com.example.entity.StockDetails;
import com.example.repo.StockDetailsRepo;
import com.example.repo.StockRepo;

@Service
public class StockService {
	@Autowired
	private StockRepo stockRepo;
	@Autowired
	private StockDetailsRepo stockDetailsRepo;
	@Autowired
	private RestTemplate resttemplte;
	
	public Stock saveUser(Stock stock) {
		  return stockRepo.save(stock);
	  }
	
	public List<Stock> getStocksByUserId(Long userId){
		return stockRepo.findByUserId(userId);
	}

	public StockCalculation calculateAmount(String companyName, Long quantity) {
		StockDetails stockDetails=stockDetailsRepo.findByStockName(companyName);
		Double amountToPay=resttemplte.getForObject("http://localhost:8085/stockcalc/"+quantity+"/"+stockDetails.getPrice(),Double.class);
		StockCalculation calculate=new StockCalculation();
		calculate.setPrice(stockDetails.getPrice());
		calculate.setStockId(stockDetails.getStockId());
		calculate.setStockName(stockDetails.getStockName());
		calculate.setAmountToPay(amountToPay);
		return calculate;
	}

	public List<StockDetails> getStockDetails() {
		List<StockDetails> stockDetails=stockDetailsRepo.findAll();
		return stockDetails;
	}

	

}
