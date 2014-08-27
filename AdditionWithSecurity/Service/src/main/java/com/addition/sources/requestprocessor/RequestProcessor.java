package com.addition.sources.requestprocessor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;
import org.apache.log4j.Logger;

import com.addition.sources.constants.Constants;
import com.comcast.addition.services.AddRequest;

public class RequestProcessor implements Processor {

	private static final Logger LOG = Logger.getLogger(RequestProcessor.class);
			
	@Override
	public void process(Exchange exchange) throws Exception {
		final String methodName = "RequestProcessor.process";
		LOG.debug("START: " + methodName );
//		Add request = exchange.getIn().getBody(Add.class);
		MessageContentsList list = exchange.getIn().getBody(MessageContentsList.class);
		AddRequest request = (AddRequest)list.get(0);
		LOG.debug("number1 from request: " + request.getNumber1() );
		LOG.debug("number2 from request: " + request.getNumber2() );		
		int number1 = request.getNumber1();
		int number2 = request.getNumber2();
		LOG.debug("number1: " + number1 );
		LOG.debug("number2: " + number2 );
		exchange.setProperty(Constants.NUMBER1, number1);
		exchange.setProperty(Constants.NUMBER2, number2);
		LOG.debug("END: " + methodName );
	}

}
