package io.tech.orderservice.exception;

@SuppressWarnings("serial")
public class OrderNotFoundRuntimeException extends RuntimeException {

	public OrderNotFoundRuntimeException(String message) {
		super(message);
	}
}
