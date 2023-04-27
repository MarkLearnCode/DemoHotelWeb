package com.example.demo.service;

import com.example.demo.model.Chkmember;
import com.example.demo.repository.ChkmemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChkmemberService {

	@Autowired
	private ChkmemberRepository cmr;
	
	public void saveChkmember(Chkmember member) {
		this.cmr.save(member);
	}
	
	
}
