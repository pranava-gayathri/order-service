package com.pranavagayathri.order_service.feign;

import com.pranavagayathri.order_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient("PRODUCT-SERVICE")
public interface OrderInterface {
    @PostMapping("product/getProducts")
    ResponseEntity<List<Product>> getProductsByIds(@RequestBody List<Integer> ids);

    @PutMapping("product/updateStock")
    void updateStock(@RequestParam int pid);

}
