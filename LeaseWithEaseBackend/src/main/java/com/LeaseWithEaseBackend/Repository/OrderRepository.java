package com.LeaseWithEaseBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LeaseWithEaseBackend.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
