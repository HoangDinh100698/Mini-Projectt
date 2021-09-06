package com.mini_project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mini_project.Entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

}