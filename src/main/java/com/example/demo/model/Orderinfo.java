package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;


/**
 * The persistent class for the orderinfo database table.
 * 
 */
@Entity
@Table(name = "orderinfo")
//@NamedQuery(name="Orderinfo.findAll", query="SELECT o FROM Orderinfo o")
public class Orderinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date chkInDate;

	private String chkMember;

	private String chkNo;

	@Temporal(TemporalType.DATE)
	private Date chkOutDate;

	private String hotelName;

	private String los;

	private String roomPrice;

	private String roomQty;

	private String roomType;

	private String ttlAMT;

	//bi-directional many-to-one association to Roomorder
	@ManyToOne
	@JoinColumn(name="orderNo",referencedColumnName = "orderNo")
	private Roomorder roomorder;

	public Orderinfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getChkInDate() {
		return this.chkInDate;
	}

	public void setChkInDate(Date chkInDate) {
		this.chkInDate = chkInDate;
	}

	public String getChkMember() {
		return this.chkMember;
	}

	public void setChkMember(String chkMember) {
		this.chkMember = chkMember;
	}

	public String getChkNo() {
		return this.chkNo;
	}

	public void setChkNo(String chkNo) {
		this.chkNo = chkNo;
	}

	public Date getChkOutDate() {
		return this.chkOutDate;
	}

	public void setChkOutDate(Date chkOutDate) {
		this.chkOutDate = chkOutDate;
	}

	public String getHotelName() {
		return this.hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLos() {
		return this.los;
	}

	public void setLos(String los) {
		this.los = los;
	}

	public String getRoomPrice() {
		return this.roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomQty() {
		return this.roomQty;
	}

	public void setRoomQty(String roomQty) {
		this.roomQty = roomQty;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getTtlAMT() {
		return this.ttlAMT;
	}

	public void setTtlAMT(String ttlAMT) {
		this.ttlAMT = ttlAMT;
	}
	@JsonIgnore
	public Roomorder getRoomorder() {
		return this.roomorder;
	}
//	@JsonIgnore
	@JsonInclude
	public void setRoomorder(Roomorder roomorder) {
		this.roomorder = roomorder;
	}

}