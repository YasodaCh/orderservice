package io.tech.orderservice.resource;

import org.springframework.data.repository.CrudRepository;

import io.tech.orderservice.entity.model.Order_Table;

public interface OrderRepository extends CrudRepository<Order_Table, Integer> {

}
