package org.chiwooplatform.cloud.sample.message;

public class MessageWrapper<T> {

	private T payload;
	private String message;

	public MessageWrapper(T payload, String message) {
		this.payload = payload;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public T getPayload() {
		return payload;
	}

}
