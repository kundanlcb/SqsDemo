package com.cm.assignment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productCode;
    private String product;
    private Integer quantity;
    private String firstName;
    private String lastName;
    private String deliveryAddressOne;
    private String deliveryAddressTwo;
    private String deliveryCity;
    private String deliveryPostCode;
    private String deliveryCountry;
    private String deliveryState;
    private String deliveryCounty;
    private String email;
    private String mobileNumberAndCode;
    private String notes;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Boolean paymentConfirmed;
    private String orderNumber;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime dispatchedAt;

    private String stripeInvoiceId;


}