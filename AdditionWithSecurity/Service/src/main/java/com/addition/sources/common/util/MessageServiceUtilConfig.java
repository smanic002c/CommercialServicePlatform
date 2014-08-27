package com.addition.sources.common.util;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.addition.sources.common.message.MessageService;





@Configuration
public class MessageServiceUtilConfig {

	private transient MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	@PostConstruct
	public void init() {
		MessageServiceUtil.setMessageService(messageService);
	}
	
	
}
