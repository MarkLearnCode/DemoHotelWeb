package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hotel;
import com.example.demo.model.Roominfo;
import com.example.demo.repository.OrderInfoRepository;
import com.example.demo.repository.RoominfoRepository;

@Service
public class RoominfoService {
	@Autowired
	private RoominfoRepository rr;
	@Autowired
	private OrderInfoRepository oir;

	public List<Roominfo> takeRoominfo(String hotelNo) {
		return rr.findByHotelNo(hotelNo);
	}

	public Map<String, List<Roominfo>> takeAllRoominfo() {
		Map<String, List<Roominfo>> roomInfoMap = new HashMap<>();
		roomInfoMap.putIfAbsent("roomInfo", rr.findAll());

		return roomInfoMap;
	}

	public List<String> availableRooms(String hotelNo, String chickInDate, String chickOutDate) {
		List<String> remainingRoomsList = new ArrayList();
		for(int i =0; i<3;i++) {
			String alroomno ="";
			if(i==0) alroomno = hotelNo+"s";
			if(i==1) alroomno = hotelNo+"d";
			if(i==2) alroomno = hotelNo+"q";
			System.out.println(alroomno);
			Roominfo roominfo = rr.findByAlroomno(alroomno);
			int roomQty = Integer.parseInt(roominfo.getRoomqty());
			System.out.println("roomQty = " + roomQty);
			int orderRoomCount = oir.roomCount(alroomno,chickInDate, chickOutDate);
			System.out.println("chickInDate = " + chickInDate);
			System.out.println("orderRoomCount = " + orderRoomCount);
			int remainingRooms = roomQty - orderRoomCount;
			remainingRoomsList.add(remainingRooms+"");
		}
//		Roominfo roominfo = rr.findByAlroomno(alroomno);
//		int roomQty = Integer.parseInt(roominfo.getRoomqty());
//		int orderRoomCount = oir.roomCount(alroomno,chickInDate, chickOutDate);
//		int remainingRooms = roomQty - orderRoomCount;
		return remainingRoomsList;
	}

//	public List<Roominfo> takeRoominfoP(String hotelNo) {
//	    return rr.findRoomInfoByHotelNo(hotelNo);
//	}
}
