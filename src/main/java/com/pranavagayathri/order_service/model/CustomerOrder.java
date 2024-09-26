package com.pranavagayathri.order_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private int customerId;
    private LocalDate orderDate;

    @ElementCollection
    private List<Integer> productIds;



}
