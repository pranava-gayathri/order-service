package com.pranavagayathri.order_service.service;

import com.pranavagayathri.order_service.feign.OrderInterface;
import com.pranavagayathri.order_service.model.CustomerOrder;
import com.pranavagayathri.order_service.model.OrderDto;
import com.pranavagayathri.order_service.model.Product;
import com.pranavagayathri.order_service.model.Status;
import com.pranavagayathri.order_service.repository.OrderRepo;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderInterface orderInterface;

//    public ResponseEntity<String> createOrder(CustomerOrder order) {
//
//        orderRepo.save(order);
//        return new ResponseEntity<>("successfully ordered", HttpStatus.CREATED);
//    }
    public ResponseEntity<String> createOrder(OrderDto orderDto) {
        System.out.println(orderDto.getPIds());

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrderDate(orderDto.getOrderDate());
        customerOrder.setCustomerId(orderDto.getCustomerId());
        customerOrder.setProductIds(orderDto.getPIds());

        orderRepo.save(customerOrder);

        return new ResponseEntity<>("successfully ordered", HttpStatus.CREATED);
    }

    public ResponseEntity<List<CustomerOrder>> getAllOrders() {
        return new ResponseEntity<>(orderRepo.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Long> calculatePrice(int orderId) {
        List<Integer> ids=orderRepo.findById(orderId).get().getProductIds();
        List<Product> products=orderInterface.getProductsByIds(ids).getBody();
        long totalAmount=0;
        for(Product p:products){
            if(p.getStatus().equals(Status.AVAILABLE)){
                orderInterface.updateStock(p.getProductId());
                totalAmount+=p.getPrize();
            }
        }
        return new ResponseEntity<>(totalAmount,HttpStatus.CREATED);


    }
}
