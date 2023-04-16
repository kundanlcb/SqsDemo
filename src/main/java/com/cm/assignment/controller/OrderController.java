package com.cm.assignment.controller;


import com.cm.assignment.dto.GenericResponse;
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
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<GenericResponse> placeOrder(@RequestBody ProductOrderDto productOrderDto){
        return new ResponseEntity<>(orderService.placeOrder(productOrderDto), HttpStatus.OK);
    }
}
