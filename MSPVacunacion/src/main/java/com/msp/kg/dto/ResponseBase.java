package com.msp.kg.dto;

import java.util.List;

public class ResponseBase {
	private boolean success;
	private List<Message> messages;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
