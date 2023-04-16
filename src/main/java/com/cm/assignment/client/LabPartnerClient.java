package com.cm.assignment.client;

import com.cm.assignment.dto.ProductOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "product-api", url = "https://api.hurdle.bio/orders/v2")
public interface LabPartnerClient {
    @PostMapping(value = "/api/placeOrder",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ProductOrderDto placeOrder(@RequestBody ProductOrderDto orderDto);
}
