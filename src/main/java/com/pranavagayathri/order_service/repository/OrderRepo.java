package com.pranavagayathri.order_service.repository;


import com.pranavagayathri.order_service.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<CustomerOrder,Integer> {

}
