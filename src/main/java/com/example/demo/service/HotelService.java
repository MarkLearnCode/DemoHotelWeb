package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import java.util.HashMap;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hr;

	public List<Hotel> getAreaHotels(String areaName) {
		List<Hotel> hotels = hr.findAllAreaHotel(areaName);
		for (int i = 0; i < hotels.size(); i++) {
			List<String> pics;
//			pics = new HotelService().getHotelPicPath(hotels.get(i).getHotelNo());
			pics = getHotelPicPath(hotels.get(i).getHotelNo());
			hotels.get(i).setPics(pics);
		}
		return hotels;
	}
	public Hotel takeHotel(String hotelNo) {
		Hotel hotel = hr.findByHotelNo(hotelNo);
		
//		List<String> pics = new HotelService().getHotelPicPath(hotelNo);
		List<String> pics = getHotelPicPath(hotelNo);
		hotel.setPics(pics);
		return hr.findByHotelNo(hotelNo);
	}

	public List<String> getHotelPicPath(String hotelNo) {
		List<String> pics = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			String path = "http://localhost:8080/hotelpics/pics/"+hotelNo+"/"+(i+1)+".jpeg";
			pics.add(path);
		}
		System.out.println("all pics = "+pics.size());
		return pics;
	}

	

	
	
	//抓取 所有的hotel資料
	public Map<String,List<Hotel>> getAllHotels() {
		Map<String, List<Hotel>> data = new HashMap<>();
		data.put("hotel", hr.findAll());

		
		 
		return data ;
	}
	

	//用id查找
	public Hotel getHotlById(int id) {
		Hotel udate = hr.getById(id);
      
        return udate;
    }
	
	//實作名字查詢
	public Hotel getHotelByname(String hotelName) {
		Hotel rdata= hr.findByHotelName(hotelName);
		
		return rdata;
		
	}
	
	//新增
	public void addHotel(Hotel hotel) {
		String x=null;
		//判斷開投英文
		switch(hotel.getArea()) {
		case "north":
			x="n";
			break;
		case "middle":
			x="m";
			break;
		case "huadong":
			x="hd";
			break;
		case "south":
			x="s";
			break;
		default:
			x="i";
			break;	
		}
		System.out.println(hotel);
		//全部的資料
		List<Hotel> data1=(List<Hotel>) hr.findAll();
		//查詢陣列區域符合的比數
		List<Hotel> addId = data1.stream()
              .filter(h -> h.getArea().equals(hotel.getArea()))
              .collect(Collectors.toList());
		
		String Y = String.format("%02d", 0);
		int newY = Integer.parseInt(Y) + addId.size()+1;
		Y = String.format("%02d", newY);		
		//新增一筆
		 String No= Y;
		 
		 //回填hotelNo
		 hotel.setHotelNo(x+No);
		 hr.save(hotel);
	}
}

//if (files == null) {
//	// 目錄為空，回傳 0
//	return 0;
//}
//return files.length;

// 資料夾路徑

// 判斷該資料夾是否存在

//if (folder.exists()) {
//	// 列出資料夾中的所有檔案
//	File[] files = folder.getFile().listFiles();
//
//	// 檔案數量
//	int fileCount = files.length;
//
//	for (int i = 0; i < fileCount; i++) {
//		picPaths.add((i + 1) + ".jpg");
//	}
//	System.out.println("資料夾中有 " + fileCount + " 個檔案。");
//} else {
//	System.out.println("找不到指定的資料夾。");
//	picPaths.add("none");
//}