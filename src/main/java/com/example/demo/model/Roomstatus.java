package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the roomstatus database table.
 * 
 */
@Entity
//@NamedQuery(name="Roomstatus.findAll", query="SELECT r FROM Roomstatus r")
public class Roomstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String chkmember;

	private String chkstatus;

	private String roomno;

	//bi-directional many-to-one association to Roominfo
	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="alroomno" , columnDefinition = "VARCHAR")
	@JoinColumn(name = "alroomno",referencedColumnName = "alroomno")
	private Roominfo roominfo;

	//bi-directional many-to-one association to Webmember
	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="rmemail" , columnDefinition = "VARCHAR")
	@JoinColumn(name = "rmemail",referencedColumnName = "email")
	private Webmember webmember;

	public Roomstatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChkmember() {
		return this.chkmember;
	}

	public void setChkmember(String chkmember) {
		this.chkmember = chkmember;
	}

	public String getChkstatus() {
		return this.chkstatus;
	}

	public void setChkstatus(String chkstatus) {
		this.chkstatus = chkstatus;
	}

	public String getRoomno() {
		return this.roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public Roominfo getRoominfo() {
		return this.roominfo;
	}
	@JsonIgnore
	public void setRoominfo(Roominfo roominfo) {
		this.roominfo = roominfo;
	}

	public Webmember getWebmember() {
		return this.webmember;
	}
	@JsonIgnore
	public void setWebmember(Webmember webmember) {
		this.webmember = webmember;
	}

}