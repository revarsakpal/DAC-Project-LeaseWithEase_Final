package com.LeaseWithEaseBackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LeaseWithEaseBackend.Model.Order;
import com.LeaseWithEaseBackend.Repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
@Autowired
OrderRepository orderRepository;

@Override
public List<Order> getAllOrders() {
	return orderRepository.findAll();
}

@Override
public Order getOrderById(int o_id) {
	Optional<Order> op=orderRepository.findById(o_id);
	return op.get();
}

@Override
public void placeOrder(Order order) {
orderRepository.save(order);	
}





}
