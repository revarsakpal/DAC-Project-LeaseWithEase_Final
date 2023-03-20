package com.LeaseWithEaseBackend.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LeaseWithEaseBackend.Model.Customer;
import com.LeaseWithEaseBackend.Model.Order;
import com.LeaseWithEaseBackend.Model.Transporter;
import com.LeaseWithEaseBackend.Service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
@Autowired
OrderService orderService;
@Autowired
TransporterController tController;

@GetMapping("orders")
public ResponseEntity<List<Order>> getAllOrders(){
	List<Order> orderList=orderService.getAllOrders();
	return ResponseEntity.ok(orderList);
}

@GetMapping("orders/{o_id}")
public ResponseEntity<Order> getOrderById(@PathVariable int o_id){
	 Order order=orderService.getOrderById(o_id);
	 return ResponseEntity.ok(order);
}

@PostMapping("placeOrder")
public ResponseEntity<String> placeOrder(@RequestBody Order order,HttpSession session){
	System.out.println(session.getAttribute("validC"));
	Customer customer=(Customer) session.getAttribute("cust");
	order.setCustomer(customer);
	Transporter transport=tController.getTransporterById(1);
	order.setTransporter(transport);
	Date date = new Date();  
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
    String strDate = formatter.format(date);  
	order.setDate(strDate);
orderService.placeOrder(order);

	return ResponseEntity.ok("Order Placed Successfully!!");
}

}
