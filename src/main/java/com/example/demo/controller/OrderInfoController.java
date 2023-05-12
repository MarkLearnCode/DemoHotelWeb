package com.example.demo.controller;

import com.example.demo.model.Orderinfo;
import com.example.demo.service.OrderInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/api")
public class OrderInfoController {

	@Autowired
	private OrderInfoService ois;

	@PostMapping("/orderinfo")
	@CrossOrigin("*")
	public String createOrderInfo(@RequestBody Orderinfo orderDetail) {
		System.out.println("Orderinfo orderDetail = "+orderDetail);
		ois.saveOrderInfo(orderDetail);
		return"success";
	}
}
