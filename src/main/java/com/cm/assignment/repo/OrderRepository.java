package com.cm.assignment.repo;

import com.cm.assignment.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ProductOrder, Long> {
}