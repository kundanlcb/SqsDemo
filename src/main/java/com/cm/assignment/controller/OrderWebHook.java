package com.cm.assignment.controller;

import com.cm.assignment.dto.ProductOrderDto;
import com.cm.assignment.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderWebHook {
    private final OrderService orderService;

    @PostMapping("/labpartner/webhook")
    public ResponseEntity<String> updateOrder(@RequestBody ProductOrderDto productOrderDto){
        return new ResponseEntity<>(orderService.updateOrderStatus(productOrderDto), HttpStatus.OK);
    }
}
