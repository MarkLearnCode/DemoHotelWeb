package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the roominfo database table.
 * 
 */
@Entity
//@NamedQuery(name="Roominfo.findAll", query="SELECT r FROM Roominfo r")
public class Roominfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String alroomno;

	private String price;

	private String roomqty;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
//	@JoinColumn(name="hotelNo", columnDefinition = "VARCHAR")
	 @JoinColumn(name = "hotelNo", referencedColumnName = "hotelNo")
	private Hotel hotel;
	

	//bi-directional many-to-one association to Roomstatus
	@OneToMany(mappedBy="roominfo",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Roomstatus> roomstatuses;

	public Roominfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlroomno() {
		return this.alroomno;
	}

	public void setAlroomno(String alroomno) {
		this.alroomno = alroomno;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRoomqty() {
		return this.roomqty;
	}

	public void setRoomqty(String roomqty) {
		this.roomqty = roomqty;
	}

 	public Hotel getHotel() {
		return this.hotel;
	}
 	@JsonIgnore
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Roomstatus> getRoomstatuses() {
		return this.roomstatuses;
	}

	public void setRoomstatuses(List<Roomstatus> roomstatuses) {
		this.roomstatuses = roomstatuses;
	}

	public Roomstatus addRoomstatus(Roomstatus roomstatus) {
		getRoomstatuses().add(roomstatus);
		roomstatus.setRoominfo(this);

		return roomstatus;
	}

	public Roomstatus removeRoomstatus(Roomstatus roomstatus) {
		getRoomstatuses().remove(roomstatus);
		roomstatus.setRoominfo(null);

		return roomstatus;
	}

}