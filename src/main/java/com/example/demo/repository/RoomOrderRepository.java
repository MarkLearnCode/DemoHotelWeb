package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Roomorder;

public interface RoomOrderRepository extends JpaRepository<Roomorder, Integer> {
//	@Query(value = "select * from roomorder where orderNo =?1", nativeQuery = true)
//	Roomorder findByOrderNo(String orderNo);
	Roomorder findByOrderNo(String orderNo);
	
	@Query(value = "select * from roomorder where email =?1", nativeQuery = true)
	List<Roomorder> findByEmail(String email);
}
