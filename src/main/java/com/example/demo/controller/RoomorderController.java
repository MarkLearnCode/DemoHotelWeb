package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.persistence.EntityManager;

import com.example.demo.model.Orderinfo;
import com.example.demo.model.Roomorder;
import com.example.demo.model.Webmember;
import com.example.demo.service.RoomorderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class RoomorderController {
	@Autowired
	private RoomorderService os;
	
	@PostMapping("/order")
	@CrossOrigin("*")
	public String createOrder(@RequestBody Roomorder orderForm) {
//		System.out.println(orderForm.getNote());
//		System.out.println(orderForm.getWebmember().getEmail());
		String odNo = os.createNo();
		orderForm.setOrderNo(odNo);
		
//		orderForm.addOrderinfo(null);
//		System.out.println(orderForm.toString());
//		orderForm.addOrderinfo(null)
		System.out.println(orderForm.getOrderinfos().get(0));
//		orderForm.getOrderinfos().get(0).getRoomorder().setOrderNo(odNo);
		
		orderForm.getOrderinfos().get(0).setRoomorder(orderForm);
		
//		Orderinfo orderinfo = orderForm.getOrderinfos().get(0);
//	    orderinfo.setRoomorder(orderForm);
//	    orderForm.addOrderinfo(orderinfo);
		
//		System.out.println(orderForm.toString());
		System.out.println("Roomorder orderForm = "+orderForm);
		os.saveOrder(orderForm);
		return "success";
	}
	@GetMapping("/info/{email}")
	@CrossOrigin("*")
	public ResponseEntity<Map<String, List<Roomorder>>> findOrderInfoByEmail(@PathVariable("email") String email) {
        System.out.println(email);
        List<Roomorder> details = os.findroomorder(email);
        System.out.println(details);
        Map<String,List<Roomorder>> result=new HashMap<>();
        result.put("data",details);
        return ResponseEntity.ok().body(result);
    }
	
}

