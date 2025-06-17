package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Stock;

public interface StockRepo extends JpaRepository<Stock, Long>{

	List<Stock> findByUserId(Long userId);

}
