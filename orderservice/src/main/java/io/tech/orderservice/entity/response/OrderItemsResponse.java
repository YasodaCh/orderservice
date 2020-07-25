package io.tech.orderservice.entity.response;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import io.tech.orderservice.entity.request.OrderItem;

@Component
public class OrderItemsResponse implements Serializable {

	OrderItem orderItem;
	String msg;
	String respCd;

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRespCd() {
		return respCd;
	}

	public void setRespCd(String respCd) {
		this.respCd = respCd;
	}

}
