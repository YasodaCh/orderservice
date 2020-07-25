package io.tech.orderservice.exception;

public class OrderNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3948279429129090266L;

	public OrderNotFoundException(String message) {
		super(message);
	}
}
