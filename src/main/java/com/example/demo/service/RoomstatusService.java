package com.example.demo.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hotel;
import com.example.demo.model.Roomstatus;
import com.example.demo.repository.HotelRepository;
import java.util.logging.Logger;
import com.example.demo.repository.RoomstatusRepository;

@Service
public class RoomstatusService {
	   private HotelRepository hr;
	   
	   @Autowired
	   private RoomstatusRepository rf;
   
	   
	   
	   
	   public List<Roomstatus> findByRoominfo_Alroomno(String alroomno){
		   List<Roomstatus>  data= rf.findByRoominfo_Alroomno(alroomno);
		   
		return data;
		   
	   }
	   

	   public Map<String, Integer> getSroom1(String hotelName) {

		    
		    List<Hotel> data = hr.findAll();
		    Optional<Hotel> hn = data.stream()
		            .filter(h -> h.getHotelName().equals(hotelName))
		            .findFirst();

		    Hotel hotel = hn.orElse(null);
		    if (hn.isPresent()) {
		        hotel = hn.get();
		        // 使用 hotel 物件進行後續處理
		    } else {
		        // Handle the case when hotel is not found
		        System.out.println("Hotel with name {} not found"+hotelName);
		        return null;
		    }

		    String hotelNo = hotel.getHotelNo();
		    String Sr = hotelNo + "s";
		    String Dr = hotelNo + "d";
		    String Qr = hotelNo + "q";

		    List<Roomstatus> Scount = rf.findByRoominfo_Alroomno(Sr);
		    int Srom = (int) Scount.stream()
		            .filter(r -> r.getChkstatus().equals("N"))
		            .count();

		    List<Roomstatus> Dcount = rf.findByRoominfo_Alroomno(Dr);
		    int Drom = (int) Dcount.stream()
		            .filter(r -> r.getChkstatus().equals("N"))
		            .count();

		    List<Roomstatus> Qcount = rf.findByRoominfo_Alroomno(Qr);
		    int Qrom = (int) Qcount.stream()
		            .filter(r -> r.getChkstatus().equals("N"))
		            .count();

		    Map<String, Integer> Rst = new HashMap<>();
		    Rst.put("single", Srom);
		    Rst.put("double", Drom);
		    Rst.put("quad", Qrom);

		    System.out.println("Successfully retrieved room status for hotel {}"+hotelName);
		    return Rst;
		}
	   
//		

}
