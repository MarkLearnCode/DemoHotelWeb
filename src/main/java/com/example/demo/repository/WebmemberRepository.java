package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Webmember;

public interface WebmemberRepository extends JpaRepository<Webmember, Integer>{

	@Query(value="select * from webmember where email =?1",nativeQuery=true)
	Webmember findByEmail(String email);
}
