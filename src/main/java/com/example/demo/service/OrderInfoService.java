package com.example.demo.service;

import com.example.demo.model.Orderinfo;
import com.example.demo.model.Roomorder;
import com.example.demo.repository.OrderInfoRepository;
import com.example.demo.repository.RoomOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoService {
	
	@Autowired
	private OrderInfoRepository oir;
	@Autowired
	private RoomOrderRepository or;
	
	public void saveOrderInfo(Orderinfo orderDetail ) {
		String orderNo=orderDetail.getRoomorder().getOrderNo();
		Roomorder number=or.findByOrderNo(orderNo);
		if(number!=null) {
			orderDetail.setRoomorder(number);
		}
		this.oir.save(orderDetail);
	}
	

}
