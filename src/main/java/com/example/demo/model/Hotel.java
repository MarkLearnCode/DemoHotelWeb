package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@Table(name = "hotel")
@NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String address;

	private String area;

	private String city;

	private String hotelemail;

	private String hotelMap;

	private String hotelName;

	private String hotelNo;

	private String phone;

	@Transient
	private String picPath;

	@Transient
	private List<String> pics;

	// bi-directional many-to-one association to Roominfo
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER) //順便抓取roominfos
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JoinColumn(name = "hotelNo", referencedColumnName = "hotelNo")
	private List<Roominfo> roominfos = new ArrayList<>();

	public Hotel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelemail() {
		return this.hotelemail;
	}

	public void setHotelemail(String hotelemail) {
		this.hotelemail = hotelemail;
	}

	public String getHotelMap() {
		return this.hotelMap;
	}

	public void setHotelMap(String hotelMap) {
		this.hotelMap = hotelMap;
	}

	public String getHotelName() {
		return this.hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelNo() {
		return this.hotelNo;
	}

	public void setHotelNo(String hotelNo) {
		this.hotelNo = hotelNo;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Roominfo> getRoominfos() {
		return this.roominfos;
	}

	public void setRoominfos(List<Roominfo> roominfos) {
		this.roominfos = roominfos;
	}

	public Roominfo addRoominfo(Roominfo roominfo) {
		getRoominfos().add(roominfo);
		roominfo.setHotel(this);

		return roominfo;
	}

	public Roominfo removeRoominfo(Roominfo roominfo) {
		getRoominfos().remove(roominfo);
		roominfo.setHotel(null);

		return roominfo;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public List<String> getPics() {
		return pics;
	}

	public void setPics(List<String> pics) {
		this.pics = pics;
	}

}