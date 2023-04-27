package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hotel;
import com.example.demo.model.Roominfo;
import com.example.demo.repository.RoominfoRepository;

@Service
public class RoominfoService {
	@Autowired
	private RoominfoRepository rr;
	public List<Roominfo> takeRoominfo(String hotelNo) {
		return rr.findByHotelNo(hotelNo);
	}
	public Map<String,List<Roominfo>> takeAllRoominfo() {
		Map<String,List<Roominfo>> roomInfoMap = new HashMap<>();
		roomInfoMap.putIfAbsent("roomInfo", rr.findAll());
		
		return roomInfoMap;
	}
//	public List<Roominfo> takeRoominfoP(String hotelNo) {
//	    return rr.findRoomInfoByHotelNo(hotelNo);
//	}
}
