package io.tech.orderservice.entity.response;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class OrderResp implements Serializable {

	String customerName;
	String orderDate;
	String shippingAddress;
	OrderItemResponse orderItem;
	String total;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public OrderItemResponse getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItemResponse orderItem) {
		this.orderItem = orderItem;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}
