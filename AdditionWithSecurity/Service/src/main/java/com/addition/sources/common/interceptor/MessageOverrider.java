package com.addition.sources.common.interceptor;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class MessageOverrider extends AbstractPhaseInterceptor<Message> {

	public MessageOverrider() {
		super(Phase.RECEIVE);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		String encoding = (String) message.get(Message.ENCODING);
		if (encoding == null || !encoding.equals("UTF-8")) {
			message.put(Message.ENCODING, "UTF-8");
			message.put(Message.CONTENT_TYPE, "text/xml");
		}
	}

}
