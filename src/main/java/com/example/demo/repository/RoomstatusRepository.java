package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Hotel;
import com.example.demo.model.Roomstatus;

public interface RoomstatusRepository extends JpaRepository<Roomstatus, Integer>{
	@Query(value = "select * from roomstatus where alroomno=?1",nativeQuery = true)
	List<Roomstatus> findAllRoomstatusByAlroomno(String alroomno);
	
//	@Query(value = "select * from Roomstatus where alroomno=?1",nativeQuery = true)
//	List<Roomstatus> findByRoominfo_Alroomno(String alroomno);
	
}
