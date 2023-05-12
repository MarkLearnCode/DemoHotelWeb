package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Roominfo;
import com.example.demo.model.Roomorder;
import com.example.demo.model.Roomstatus;
import com.example.demo.model.Webmember;
import com.example.demo.repository.ChkmemberRepository;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.OrderInfoRepository;
import com.example.demo.repository.RoomOrderRepository;
import com.example.demo.repository.RoominfoRepository;
import com.example.demo.repository.RoomstatusRepository;
import com.example.demo.repository.WebmemberRepository;
import com.example.demo.service.RoominfoService;

@RestController
@RequestMapping(value = "/test")
public class TestCrud {
	@Autowired
	private ChkmemberRepository chkRe;
	@Autowired
	private HotelRepository hoRe;
	@Autowired
	private OrderInfoRepository odRe;
	@Autowired
	private RoominfoRepository RiRe;
	@Autowired
	private RoomOrderRepository RoRe;
	@Autowired
	private RoomstatusRepository RsRe;
	@Autowired
	private WebmemberRepository WmRe;
	@Autowired
	private RoominfoService rifs;

	@GetMapping(value = "/chk")
	public void chk() {

	}

	@GetMapping(value = "/hot")
	public void hot() {

	}

	@GetMapping(value = "/orderInfo")
	public void orderInfo() {

	}

	@GetMapping(value = "/roomInfo")
	public List<Roominfo> roomInfo() {
		return RiRe.findAll();

	}

	@GetMapping(value = "/roomOrder/{email}")
	public List<Roomorder> orderList(@PathVariable String email) {
		List<Roomorder> orderList = RoRe.findByEmail(email);
		return orderList;
	}

	@GetMapping(value = "/roomState")
	public List<Roomstatus> roomState() {
		return RsRe.findAll();
	}

	@GetMapping(value = "/roomStateAlno/{alno}")
	public List<Roomstatus> roomStateAlno(@PathVariable String alno) {
		return RsRe.findAllRoomstatusByAlroomno(alno);
	}

	@GetMapping(value = "/webMem")
	public List<Webmember> webMem() {
		return WmRe.findAll();
	}

	@GetMapping(value = "/webMem/{email}")
	public Webmember webMem(@PathVariable String email) {
		return WmRe.findByEmail(email);
	}

	@GetMapping(value = "/roomCount")
	public List<String> roomCount() {
		List<String> rooms = rifs.availableRooms("m01", "2023-05-29", "2023-05-25");
		return rooms;
	}
}
