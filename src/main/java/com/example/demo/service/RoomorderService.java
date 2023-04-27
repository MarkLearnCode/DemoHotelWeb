package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Orderinfo;
import com.example.demo.model.Roomorder;
import com.example.demo.model.Webmember;
import com.example.demo.repository.OrderInfoRepository;
import com.example.demo.repository.RoomOrderRepository;
import com.example.demo.repository.WebmemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomorderService {
	@Autowired
	private RoomOrderRepository or;
	@Autowired
	private WebmemberRepository wmr;
	@Autowired
	private OrderInfoRepository oir;

	public String createNo() {
		List<Roomorder> orderList = or.findAll();
		int orderLength = orderList.size();
		System.out.println(orderLength);
		String orderNo = "";
		if (orderLength < 9) {
			orderNo = "od0" + (orderLength + 1);
			return orderNo;
		} else if (orderLength >= 9) {
			orderNo = "od" + (orderLength + 1);
			System.out.println("orderNo = " + orderNo);
			return orderNo;
		}
//		if(orderLength>=9) {
//			orderNo = "od"+(orderLength+1);
//			return orderNo;
//		};
		System.out.println("orderNo = " + orderNo);
		return orderNo;
	}

	public void saveOrder(Roomorder orderForm) {
		String email = orderForm.getWebmember().getEmail();
		System.out.println(email);
		Webmember member = wmr.findByEmail(email);
		if (member != null) {
			orderForm.setWebmember(member);
		}
		this.or.save(orderForm);
	}

	public List<Roomorder> findroomorder(String email) {
		List<Roomorder> roomorder = (List<Roomorder>) or.findByEmail(email);
		return roomorder;
	}

}
