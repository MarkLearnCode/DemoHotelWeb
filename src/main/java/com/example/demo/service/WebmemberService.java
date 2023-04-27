package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Webmember;
import com.example.demo.repository.WebmemberRepository;

@Service
public class WebmemberService {
	@Autowired
	private WebmemberRepository wmr;
	
	public List<Webmember> allWebmembers() {
		
		return wmr.findAll();
	}
	public void saveWebmember(Webmember member) {
		this.wmr.save(member);
	}
			
	public boolean checkPassword(String email, String password) {
		
		Webmember member = wmr.findByEmail(email);
		if(member==null) {
			return false;
		}
		if(member.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public String findPasswordByEmail(String email) {
		Webmember member = wmr.findByEmail(email);
		String mb=null;
		if(member!=null) {
			mb=member.getPassword();
			return mb;
		}else {
			return "notfound";
			} 
		
	}
	

	public boolean checkEmail(String email) {
		System.out.println("hotel = "+wmr.findByEmail(email));
		Webmember member = wmr.findByEmail(email);
		if(member!=null) {
			return false;
		}
		return true;
	
	}
	public Webmember findAllByEmail(String email) {
		return wmr.findByEmail(email);		
	}
	
	public void updateWebmember(Webmember member) {
		Webmember mb=wmr.findByEmail(member.getEmail());
		mb.setName(member.getName());
		mb.setPassword(member.getPassword());
		mb.setPhone(member.getPhone());
		mb.setAddress(member.getAddress());
		this.wmr.save(mb);
		
	}
}


