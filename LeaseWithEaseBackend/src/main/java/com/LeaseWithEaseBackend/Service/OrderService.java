package com.LeaseWithEaseBackend.Service;

import java.util.List;

import com.LeaseWithEaseBackend.Model.Order;

public interface OrderService {

	List<Order> getAllOrders();

	Order getOrderById(int o_id);

	void placeOrder(Order order);

}
