package com.addition.sources.common.exception;

import java.util.List;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	public ValidationException(String sMsg) {
		super(sMsg);
	} // end constructor

	public ValidationException(List<String> sMsg) {
		this.messageList = sMsg;
	} // end constructor
	
	private List<String> messageList = null;

	public List<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}

} // end class
