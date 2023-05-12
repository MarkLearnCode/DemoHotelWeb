package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the webmember database table.
 * 
 */
@Entity
@Table(name = "webmember")
@NamedQuery(name = "Webmember.findAll", query = "SELECT w FROM Webmember w")
public class Webmember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	private String email;

	private String name;

	private String password;

	private String phone;

	// bi-directional many-to-one association to Roomstatus
	@OneToMany(mappedBy = "webmember", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Roomstatus> roomstatuses;

	// bi-directional many-to-one association to Roomorder
	@OneToMany(mappedBy = "webmember", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Roomorder> roomorders;

	public Webmember() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Roomstatus> getRoomstatuses() {
		return this.roomstatuses;
	}

	public void setRoomstatuses(List<Roomstatus> roomstatuses) {
		this.roomstatuses = roomstatuses;
	}

	public Roomstatus addRoomstatus(Roomstatus roomstatus) {
		getRoomstatuses().add(roomstatus);
		roomstatus.setWebmember(this);

		return roomstatus;
	}

	public Roomstatus removeRoomstatus(Roomstatus roomstatus) {
		getRoomstatuses().remove(roomstatus);
		roomstatus.setWebmember(null);

		return roomstatus;
	}

	@JsonIgnore
	public List<Roomorder> getRoomorders() {
		return this.roomorders;
	}

	public void setRoomorders(List<Roomorder> roomorders) {
		this.roomorders = roomorders;
	}

	public Roomorder addRoomorder(Roomorder roomorder) {
		getRoomorders().add(roomorder);
		roomorder.setWebmember(this);

		return roomorder;
	}

	public Roomorder removeRoomorder(Roomorder roomorder) {
		getRoomorders().remove(roomorder);
		roomorder.setWebmember(null);

		return roomorder;
	}

}