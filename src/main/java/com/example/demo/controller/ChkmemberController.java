package com.example.demo.controller;

import com.example.demo.model.Chkmember;
import com.example.demo.model.Webmember;
import com.example.demo.service.ChkmemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ChkmemberController {
	@Autowired
	private ChkmemberService cms;
	
	@PostMapping("/guest")
	@CrossOrigin("*")
	 public String createWebmember(@RequestBody Chkmember member) {
		System.out.println(member.getName());
        cms.saveChkmember(member);        
		return "success";
    }
	
	
	

}
