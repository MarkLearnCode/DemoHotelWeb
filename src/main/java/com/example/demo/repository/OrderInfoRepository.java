package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Orderinfo;

public interface OrderInfoRepository extends JpaRepository<Orderinfo, Integer> {

}
