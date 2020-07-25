package io.tech.orderservice.entity.response;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class MainOrderResp implements Serializable {

	OrderResp orderResp;
	String msg;
	String respCd;

	public OrderResp getOrderResp() {
		return orderResp;
	}

	public void setOrderResp(OrderResp orderResp) {
		this.orderResp = orderResp;
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
