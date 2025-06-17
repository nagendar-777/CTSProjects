package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.entity.ResponseTemplate;
import com.example.entity.Stock;
import com.example.entity.User;
import com.example.repo.UserRepo;
@Service
public class UserService {
  @Autowired
	private UserRepo userRepo;
  @Autowired
  private RestTemplate resttemplate;
  
  public User saveUser(User user) {
	  return userRepo.save(user);
  }
  


public ResponseTemplate getUserStocks(Long userId) {
	 ResponseTemplate responseTemplate=new ResponseTemplate();
	  User user=userRepo.findByUserId(userId);
	  List<Stock> listofstocks=resttemplate.getForObject("http://localhost:8082/stock/"+userId, List.class);
	  responseTemplate.setStockList(listofstocks);
	  responseTemplate.setUser(user);
	return responseTemplate;
}
}
