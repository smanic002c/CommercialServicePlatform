package com.addition.sources.common.message;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;



public class MessageService implements MessageSourceAware {

	private transient MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String getMessage(String key) {
		return messageSource.getMessage(key, null, Locale.US);
	}

	public String getMessage(String key, Object[] objArray) {
		return messageSource.getMessage(key, objArray, Locale.US);
	}

}
