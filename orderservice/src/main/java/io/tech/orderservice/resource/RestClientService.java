package io.tech.orderservice.resource;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Headers;
import io.tech.orderservice.entity.request.OrderItem;
import io.tech.orderservice.entity.response.OrderItemResp;
import io.tech.orderservice.entity.response.OrderItemsResponse;

@Headers("Content-Type: application/json")
@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface RestClientService {
	@RequestMapping(value = "/api/orderitem/save", method = RequestMethod.POST)
	OrderItemResp save(@RequestBody OrderItem employee);

	@RequestMapping(value = "api/orderitem/{id}", method = RequestMethod.GET)
	OrderItemsResponse getOrderItem(@PathVariable("id") int id);
}
