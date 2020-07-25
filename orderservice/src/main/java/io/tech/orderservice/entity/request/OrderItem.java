package io.tech.orderservice.entity.request;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class OrderItem implements Serializable {

	private int id;
	String productCode;
	String productName;
	String quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
