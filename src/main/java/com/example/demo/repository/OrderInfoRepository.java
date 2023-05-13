package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Orderinfo;

public interface OrderInfoRepository extends JpaRepository<Orderinfo, Integer> {

	@Query(value = "SELECT COUNT(*) AS total FROM orderinfo WHERE roomType =?1 AND chkOutDate >= ?2 AND chkInDate <= ?3", nativeQuery = true)
	int roomCount(String roomType, String chickInDate, String chickOutDate);
}
