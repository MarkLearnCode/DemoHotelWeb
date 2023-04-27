package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.demo.model.Webmember;
import com.example.demo.service.WebmemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class MemberController {

	// @Autowired
	// private MemberSQL memberSQL;
	//
	// @RequestMapping(value = "/memberSava")
	// public String memberSava() {
	// Member m1 = new Member(1, "Jack", "paww", "wong@email", "wong", "0999",
	// "taipei");
	// memberSQL.save(m1);
	// return "SAVE success";
	// }
	// @RequestMapping(value = "/findMember")
	// public Member findMember() {
	// Member m = memberSQL.findByUsername("Jack");
	// System.out.println(m.getEmail());
	// return m;
	// }
	@Autowired
	private WebmemberService wms;

	@GetMapping
	public List<Webmember> getAllWebmembers() {
		return wms.allWebmembers();
	}

	@PostMapping("/signup")
	@CrossOrigin("*")
	public String createWebmember(@RequestBody Webmember newmember) {
		System.out.println(newmember.getEmail());
		newmember.setId(0);
		wms.saveWebmember(newmember);

		return "signup";
	}

	@PostMapping("/login")
	@CrossOrigin("*")
	public boolean loginMember(@RequestBody List<String> loginInfo) {
		String email = loginInfo.get(0);
		String password = loginInfo.get(1);

		System.out.println(loginInfo.get(0));
		System.out.println(loginInfo.get(1));

		return wms.checkPassword(email, password);
	}

	@GetMapping("/forget/{email}")
	@CrossOrigin("*")
	public String forgetPassword(@PathVariable("email") String email) {
		System.out.println(email);
		wms.findPasswordByEmail(email);
		System.out.println(wms.findPasswordByEmail(email));
		return wms.findPasswordByEmail(email);
	}

	@PostMapping("/check")
	@CrossOrigin("*")
	public boolean checkMember(@RequestBody String email) {
		System.out.println(email);
		String email1 = email;
		System.out.println(wms.checkEmail(email));
		return wms.checkEmail(email);
	}

	@PostMapping("/update/{email}")
	@CrossOrigin("*")
	public String updateMemeber(@RequestBody Webmember member) {
		System.out.println(member);
		wms.updateWebmember(member);
		return "success";
	}

	@GetMapping("/all/{email}")
	@CrossOrigin("*")
	public ResponseEntity<Webmember> findAllMember(@PathVariable("email") String email) {
		System.out.println(email);
		Webmember member = wms.findAllByEmail(email);
		System.out.println(member);
		return ResponseEntity.ok(member);
	}

}
