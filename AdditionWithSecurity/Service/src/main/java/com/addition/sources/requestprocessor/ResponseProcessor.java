package com.addition.sources.requestprocessor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import com.addition.sources.constants.Constants;
import com.comcast.addition.services.AddResponse;

public class ResponseProcessor implements Processor {
	
	private static final Logger LOG = Logger.getLogger(ResponseProcessor.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		final String methodName = "ResponseProcessor.process";
		LOG.debug("START: " + methodName );
		AddResponse response = new AddResponse();
		int number1 = (Integer)exchange.getProperty(Constants.NUMBER1);
		int number2 = (Integer)exchange.getProperty(Constants.NUMBER2);
		LOG.debug("Received number1: " + number1 + " and number2: " + number2 );
		int sum = number1 + number2;
		LOG.debug("sum: " + sum );
		response.setSum(sum);
		exchange.getOut().setBody(response);
		LOG.debug("END: " + methodName );
	}

}
