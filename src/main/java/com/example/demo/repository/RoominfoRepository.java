package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Roominfo;

public interface RoominfoRepository extends JpaRepository<Roominfo, Integer> {
	@Query(value = "select * from roominfo where hotelNo=?1",nativeQuery = true)
	List<Roominfo> findByHotelNo(String hotelNo);
//	@Query(value = "select * from roominfo where hotelNo = :hotelNo", nativeQuery = true)
//	List<Roominfo> findRoomInfoByHotelNo(@Param("hotelNo") String hotelNo);
//	List<Roominfo> findByHotelHotelNo(String hotelNo);
}
