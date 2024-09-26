package com.pranavagayathri.order_service.controller;

import com.pranavagayathri.order_service.model.CustomerOrder;
import com.pranavagayathri.order_service.model.OrderDto;
import com.pranavagayathri.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

//    @PostMapping("createOrder")
//    public ResponseEntity<String> createOrder(@RequestBody CustomerOrder order){
//        return orderService.createOrder(order);
//    }
    @PostMapping("createOrder")
   public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto){
       return orderService.createOrder(orderDto);
    }


    @GetMapping("allOrders")
    public ResponseEntity<List<CustomerOrder>> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("totalAmount/{orderId}")
    public ResponseEntity<Long> calculatePrice(@PathVariable int orderId){
        return orderService.calculatePrice(orderId);
    }



}
