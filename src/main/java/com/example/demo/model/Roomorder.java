package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the roomorder database table.
 * 
 */
@Entity
@NamedQuery(name="Roomorder.findAll", query="SELECT r FROM Roomorder r")
public class Roomorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String hotelName;

	private String roomQty;

	private String note;

	private String orderNo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderTime;

	private String ttlAmt;

	//bi-directional many-to-one association to Orderinfo
	@OneToMany(mappedBy="roomorder",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@Fetch(FetchMode.JOIN)
	private List<Orderinfo> orderinfos;

	//bi-directional many-to-one association to Webmember
	@ManyToOne
	@JoinColumn(name="email",referencedColumnName = "email")
	private Webmember webmember;

	public Roomorder() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelName() {
		return this.hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomQty() {
		return this.roomQty;
	}

	public void setRoomQty(String roomQty) {
		this.roomQty = roomQty;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getTtlAmt() {
		return this.ttlAmt;
	}

	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
//	@JsonIgnore
	public List<Orderinfo> getOrderinfos() {
		return this.orderinfos;
	}
	public void setOrderinfos(List<Orderinfo> orderinfos) {
		this.orderinfos = orderinfos;
	}

	public Orderinfo addOrderinfo(Orderinfo orderinfo) {
		getOrderinfos().add(orderinfo);
		orderinfo.setRoomorder(this);

		return orderinfo;
	}

	public Orderinfo removeOrderinfo(Orderinfo orderinfo) {
		getOrderinfos().remove(orderinfo);
		orderinfo.setRoomorder(null);

		return orderinfo;
	}

	public Webmember getWebmember() {
		return this.webmember;
	}
//	@JsonIgnore
	@JsonInclude
	public void setWebmember(Webmember webmember) {
		this.webmember = webmember;
	}

	@Override
	public String toString() {
		return "Roomorder [id=" + id + ", hotelName=" + hotelName + ", roomQty=" + roomQty + ", note=" + note
				+ ", orderNo=" + orderNo + ", orderTime=" + orderTime + ", ttlAmt=" + ttlAmt + ", orderinfos="
				+ orderinfos + ", webmember=" + webmember + "]";
	}
	
	
}