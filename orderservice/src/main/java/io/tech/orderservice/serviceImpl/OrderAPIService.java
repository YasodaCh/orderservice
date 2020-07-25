package io.tech.orderservice.serviceImpl;

import org.springframework.stereotype.Service;

import io.tech.orderservice.entity.model.Order_Table;
import io.tech.orderservice.entity.response.MainOrderResp;

@Service
public interface OrderAPIService {

	public void saveOrUpdate(Order_Table orderData);

	public MainOrderResp getOrderById(int orderId);

}
