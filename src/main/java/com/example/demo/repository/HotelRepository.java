package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	@Query(value = "select * from hotel where area=?1",nativeQuery = true)
	List<Hotel> findAllAreaHotel(String areaName);
	@Query(value = "select * from hotel where hotelNo=?1",nativeQuery = true)
	Hotel findByHotelNo(String hotelNo);
		
	@Query(value = "select * from hotel where id=?1",nativeQuery = true)
	Hotel findById(int id);
	
	@Query(value = "select * from hotel where hotelName=?1",nativeQuery = true)
	Hotel findByname(String hotelName);
}

