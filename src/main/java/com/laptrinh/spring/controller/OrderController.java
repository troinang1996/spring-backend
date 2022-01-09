package com.laptrinh.spring.controller;

import com.laptrinh.spring.dto.Response.OrderResponse;
import com.laptrinh.spring.entity.Order;
import com.laptrinh.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("getall")
    public ResponseEntity<OrderResponse[]> getAll(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }


}
