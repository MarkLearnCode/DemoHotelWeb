package com.example.demo.controller;

import com.example.demo.model.Orderinfo;
import com.example.demo.model.Roomorder;
import com.example.demo.repository.OrderInfoRepository;
import com.example.demo.repository.RoomOrderRepository;
import com.example.demo.service.OrderInfoService;

import java.util.List;

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
	@Autowired 
	private RoomOrderRepository ror;
	@Autowired
	public OrderInfoRepository oir;

	@PostMapping("/orderinfo")
	@CrossOrigin("*")
	public String createOrderInfo(@RequestBody Orderinfo orderDetail) {
		List<Roomorder> roList = ror.findAll();
		int listLength = roList.size();
//		String orderNo = roList.get(listLength-1).getOrderNo();
		orderDetail.setRoomorder(roList.get(listLength-1));
		System.out.println("Orderinfo orderDetail = "+orderDetail);
		oir.save(orderDetail);
//		ois.saveOrderInfo(orderDetail);
		return"success";
	}
}
