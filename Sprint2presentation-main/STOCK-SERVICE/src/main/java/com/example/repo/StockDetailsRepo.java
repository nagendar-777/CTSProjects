package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.StockDetails;

public interface StockDetailsRepo extends JpaRepository<StockDetails, Long>{

	StockDetails findByStockName(String companyName);

}
