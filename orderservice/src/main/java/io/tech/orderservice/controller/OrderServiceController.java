package io.tech.orderservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.tech.orderservice.entity.model.Order_Table;
import io.tech.orderservice.entity.request.OrderItem;
import io.tech.orderservice.entity.response.MainOrderResp;
import io.tech.orderservice.entity.response.OrderItemResp;
import io.tech.orderservice.resource.RestClientService;
import io.tech.orderservice.serviceImpl.OrderAPIService;

@RestController
@RequestMapping("/api")
public class OrderServiceController {
	static Logger logger = LoggerFactory.getLogger(OrderServiceController.class);

	@Autowired
	OrderAPIService orderAPIService;
	@Autowired
	RestClientService restClientService;

	@GetMapping("/healthcheck")
	public String getHealthCheck() {
		logger.info("Message logged at order service healthcheck !!!");
		return "I am available!!!";
	}

	@PostMapping("/neworder")
	private int saveOrder(@Valid @RequestBody Order_Table order) {
		orderAPIService.saveOrUpdate(order);
		return order.getId();
	}

	@GetMapping("/order/{id}")
	private MainOrderResp getOrder(@PathVariable("id") int id) {
		return orderAPIService.getOrderById(id);
	}

	@PostMapping("/orderitem/save")
	private OrderItemResp saveOrderItem(@Valid @RequestBody OrderItem order) {
		return restClientService.save(order);
	}

}
