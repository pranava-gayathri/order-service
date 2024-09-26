package com.pranavagayathri.order_service.model;

import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDto {
    private int customerId;
    private LocalDate orderDate;
    @JsonProperty("pIds")
    private List<Integer> productIds;//pids
}
