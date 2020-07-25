package io.tech.orderservice.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.tech.orderservice.entity.model.Order_Table;
import io.tech.orderservice.entity.response.MainOrderResp;
import io.tech.orderservice.entity.response.OrderItemResponse;
import io.tech.orderservice.entity.response.OrderItemsResponse;
import io.tech.orderservice.entity.response.OrderResp;
import io.tech.orderservice.exception.OrderNotFoundException;
import io.tech.orderservice.resource.OrderRepository;
import io.tech.orderservice.resource.RestClientService;

@Service
public class OrderAPIServiceImpl implements OrderAPIService {
	static Logger logger = LoggerFactory.getLogger(OrderAPIServiceImpl.class);
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	RestClientService restClientService;

	@Override
	public void saveOrUpdate(Order_Table orderData) {
		orderRepository.save(orderData);
	}

	@Override
	public MainOrderResp getOrderById(int orderId) {

		MainOrderResp mainOrderResp = new MainOrderResp();
		OrderResp orderResp = null;
		OrderItemResponse orderItemResponse = null;
		try {
			Order_Table orderTable = orderRepository.findOne(orderId);

			if (orderTable != null) {
				orderResp = new OrderResp();
				OrderItemsResponse orderItem = restClientService.getOrderItem(orderId);
				if (orderItem != null) {
					orderItemResponse = new OrderItemResponse();
					if (orderItem.getOrderItem() != null) {
						orderItemResponse.setProductCode(orderItem.getOrderItem().getProductCode());
						orderItemResponse.setProductName(orderItem.getOrderItem().getProductName());
						orderItemResponse.setQuantity(orderItem.getOrderItem().getQuantity());
					}
					orderItemResponse.setMsg(orderItem.getMsg());
				}
				orderResp.setCustomerName(orderTable.getCustomerName());
				orderResp.setOrderDate(orderTable.getOrderDate());
				orderResp.setShippingAddress(orderTable.getShippingAddress());
				orderResp.setOrderItem(orderItemResponse);
				orderResp.setTotal(orderTable.getTotal());

				mainOrderResp.setOrderResp(orderResp);
				mainOrderResp.setMsg("Success");
				mainOrderResp.setRespCd("200");

			} else {
				mainOrderResp.setOrderResp(orderResp);
				mainOrderResp.setMsg("Order is not found for the id " + orderId);
				mainOrderResp.setRespCd("400");
				throw new OrderNotFoundException("Order is not found for the id " + orderId);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return mainOrderResp;
	}

}
