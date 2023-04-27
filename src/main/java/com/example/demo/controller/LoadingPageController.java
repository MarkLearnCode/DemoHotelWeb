package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Hotel;
import com.example.demo.model.Roominfo;
import com.example.demo.model.Roomorder;
import com.example.demo.model.Roomstatus;
import com.example.demo.model.Webmember;
import com.example.demo.repository.OrderInfoRepository;
import com.example.demo.repository.RoomOrderRepository;
import com.example.demo.repository.RoominfoRepository;
import com.example.demo.repository.RoomstatusRepository;
import com.example.demo.repository.WebmemberRepository;
import com.example.demo.service.HotelService;
import com.example.demo.service.RoominfoService;
import com.example.demo.service.RoomstatusService;

@RestController
@RequestMapping(value = "/api")
public class LoadingPageController {
	@Autowired
	private HotelService hs;
	@Autowired
	private RoominfoService rs;
	@Autowired
	private RoomstatusRepository rr;
	@Autowired
	private RoomOrderRepository or;
	
	@Autowired
	private RoomstatusService rss;
	
	@Autowired
	private RoomstatusRepository d;
	
	@Autowired
	private RoominfoRepository x;
	
	@Autowired
	private WebmemberRepository m;
	
	@Autowired
	private OrderInfoRepository o;
	
	@Autowired
	private RoomOrderRepository xx;
	
//	private RoomstatusRepository d;
//	private RoominfoRepository x;
	
	@GetMapping("/area/{areaName}")
	@CrossOrigin("*")
	public List<Hotel> areaName(@PathVariable String areaName) {
		if (areaName.equals("north")) {
			System.out.println("*****north*****");
			System.out.println(hs.getAreaHotels(areaName).get(0).getHotelNo());
			return hs.getAreaHotels(areaName);
		}
		if (areaName.equals("middle")) {
			System.out.println("*****middle*****");
			return hs.getAreaHotels(areaName);
		}
		if (areaName.equals("south")) {
			System.out.println("*****south*****");
			return hs.getAreaHotels(areaName);
		}
		if (areaName.equals("huadong")) {
			System.out.println("*****huadong*****");
			return hs.getAreaHotels(areaName);
		}
		if (areaName.equals("island")) {
			System.out.println("*****island*****");
			return hs.getAreaHotels(areaName);
		}
		return null;
	}
	
	@GetMapping("/hoetl/{hotelNo}")
	@CrossOrigin("*")
	public Hotel takeHotel(@PathVariable String hotelNo) {
		return hs.takeHotel(hotelNo);
	}
		
	@GetMapping("/takeRoominfo/{hotelNo}")
	@CrossOrigin("*")
	public List<Roominfo> takeRoominfo(@PathVariable String hotelNo) {
		System.out.println(hotelNo);
		return rs.takeRoominfo(hotelNo);
	}
	@GetMapping("/takeAllRoominfo")
	@CrossOrigin("*")
	public Map<String,List<Roominfo>> takeAllRoominfo() {
		return rs.takeAllRoominfo();
	}
	@GetMapping("/takeRooms/{alroomno}")
	@CrossOrigin("*")
	public List<Roomstatus> takeRooms(@PathVariable String alroomno) {
		System.out.println(alroomno);
		return rr.findAllRoomstatusByAlroomno(alroomno);
	}
	@GetMapping("/takeAllRooms")
	@CrossOrigin("*")
	public List<Roomstatus> takeAllRooms() {
		return rr.findAll();
	}
	
	@GetMapping("/memberView")
	@CrossOrigin("*")
	public Map<String, List<Hotel>> findHotel(){

		
		return  hs.getAllHotels() ;
	}
	
	@PostMapping("/addhotel")
	@CrossOrigin("*")
	  public  Hotel addHotel(@RequestBody Hotel hotel) {
		  	
		 hs.addHotel(hotel); 
		return null;		  
	  }
	
	@GetMapping("/updateID/{id}")
	@CrossOrigin("*")
	public Hotel updatahotel(@PathVariable int id) {
		

			
			 Hotel udate = hs.getHotlById(id);
		    
		   System.out.println(udate);
		  return udate;
	}
	
	@PostMapping("/updateID/{id}")
	@CrossOrigin("*")
	public Hotel updateHotel(@PathVariable("id") int id, @RequestBody Hotel hotel) {
	    Hotel oldHotel = hs.getHotlById(id);
	    if (oldHotel == null) {
	        // 若找不到對應的飯店，回傳 null 或自訂錯誤訊息
	        return null;
	    }
	    // 更新舊有資料
	    oldHotel.setHotelName(hotel.getHotelName());
	    oldHotel.setPhone(hotel.getPhone());
	    oldHotel.setHotelemail(hotel.getHotelemail());
	    oldHotel.setCity(hotel.getCity());
	    oldHotel.setAddress(hotel.getAddress());
	    oldHotel.setArea(hotel.getArea());
	    oldHotel.setHotelMap(hotel.getHotelMap());
	    // 儲存更新後的資料
	    hs.addHotel(oldHotel);
	    return oldHotel;
	}
	
	//抓取房型資料利用飯店名稱 查詢
	@GetMapping("/x/{hotelName}")
	@CrossOrigin("*")
	public 	Map<String, Integer>  getStatus(@PathVariable("hotelName") String hotelName) {

		
		
		System.out.println(hotelName);
		   Hotel hotel=hs.getHotelByname(hotelName);		   		  
		    
		    String hotelNo = hotel.getHotelNo();
		    System.out.println(hotelNo);
		    
		    String Sr = hotelNo + "s";
		    String Dr = hotelNo + "d";
		    String Qr = hotelNo + "q";
		    
		    System.out.println(Sr);
		    
		    
		    List<Roomstatus> Scount = rss.findByRoominfo_Alroomno(Sr);
		    
		    System.out.println(Scount);
		    
		    int Srom = (int) Scount.stream()
		            .filter(r -> r.getChkstatus().equals("N"))
		            .count();

		    List<Roomstatus> Dcount = rss.findByRoominfo_Alroomno(Dr);
		    int Drom = (int) Dcount.stream()
		            .filter(r -> r.getChkstatus().equals("N"))
		            .count();

		    List<Roomstatus> Qcount = rss.findByRoominfo_Alroomno(Qr);
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
	
	//抓取所有的會員資料
		@GetMapping("/wmember")
		@CrossOrigin("*")
		public  Map<String, List<Webmember>> searchuser(){
			Map<String, List<Webmember>> data = new HashMap<>();
			data.put("webmember", m.findAll());		
			return data;		
		}
		//點擊後抓取詳細資料
		@GetMapping("/roomorder/{email}")
		@CrossOrigin("*")
		public  Map<String, List<Roomorder>> findOrderInfo(@PathVariable("email") String email){
			Map<String, List<Roomorder>> data = new HashMap<>();
			List<Roomorder> order =xx.findByEmail(email);
			data.put("order", order);
				
			return data;		
		}
	
//	@GetMapping("/area/*")
//	public ModelAndView errorPage() {
//		return new ModelAndView("errorPage");
//	}
//	@GetMapping("/testSave")
//	public String saveOrder() {
//		Roomorder od = new Roomorder();
//		od.setOrderNo("test2");
//		od.setRoomQty("QTY");
//		or.save(od);
//		return "success";
//		
//	}
}
