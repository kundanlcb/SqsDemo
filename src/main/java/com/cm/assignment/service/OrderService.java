package com.cm.assignment.service;

import com.cm.assignment.dto.GenericResponse;
import com.cm.assignment.dto.ProductOrderDto;
import com.cm.assignment.sqs.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final PublisherService publisherService;

    public GenericResponse placeOrder(ProductOrderDto productOrderDto) {
        publisherService.sendOrderToQueue(productOrderDto);
        //TODO publish to sqs
        GenericResponse response = new GenericResponse();
        response.msg = "Sent to queue";
        return response;
    }

    public String updateOrderStatus(ProductOrderDto productOrderDto) {
        //TODO update status of order
        return "";
    }
}
