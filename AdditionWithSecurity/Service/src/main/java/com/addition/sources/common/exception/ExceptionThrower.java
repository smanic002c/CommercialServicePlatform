package com.addition.sources.common.exception;

/**
 * This class implements the static methods for throwing system and application exceptions
 * 
 * 
 * @author cognizant
 *
 */
public class ExceptionThrower {

//	private static final Log LOG = LogFactory.getLog(ExceptionThrower.class);

	private ExceptionThrower(){}
	
	/**
	 * This method constructs an application exceptions and sets the fault in
	 * the exchange
	 * 
	 * @param exchange
	 * @param key
	 */
	
	/*public static AdditionServiceFault throwApplicationException(List<String> keyList,Exchange exchange) throws Exception{
		
		LOG.info("ExceptionThrower::throwApplicationException()::enters");

		TNManagementServiceFault fault = getServiceFault(keyList);	
		exchange.getOut().setFault(true);
		exchange.getOut().setBody(fault);
		logPerformanceStats(exchange);
					
		LOG.info("ExceptionThrower::throwApplicationException()::exits");
		
		return fault;
		
	}*/
	
	/**
	 * This method constructs an application exceptions and sets the fault in the exchange
	 * 
	 * @param exchange
	 * @param key
	 */

	/*public static void  throwApplicationException(Exchange exchange,String key)
	{
		final String methodName = "throwApplicationException(Exchange exchange,String key)";
		LOG.debug("START: " + methodName );
		String value=MessageServiceUtil.getMessage(key);
		LOG.debug("value: "  +value);
		TNManagementServiceFault customerServiceFault= getFault(key,value);
		exchange.getOut().setFault(true);
		exchange.getOut().setBody(customerServiceFault);
		logError(customerServiceFault,exchange);
		logPerformanceStats(exchange);
		LOG.debug("END: " + methodName );
	}

	*//**
	 * This method constructs an application exception using message from down stream systems and sets the fault in the exchange 
	 * @param exchange
	 * @param key
	 * @param objArray
	 *//*
	public static void  throwApplicationException(Exchange exchange,String key,Object[]  objArray)
	{
		final String methodName = "throwApplicationException(Exchange exchange,String key,Object[]  objArray)";
		LOG.debug("START: " + methodName );
		String value=MessageServiceUtil.getMessage(key,objArray);
		LOG.debug("value: "  +value);
		TNManagementServiceFault customerServiceFault= getFault(key,value);
		exchange.getOut().setFault(true);
		exchange.getOut().setBody(customerServiceFault);
		logError(customerServiceFault,exchange);
		logPerformanceStats(exchange);
		LOG.debug("END: " + methodName );
	}

	*//**
	 * This method constructs an system exception  and sets the fault in the exchange .Used while the downstream systems are not responding.
	 * 
	 * @param exchange
	 * @param key
	 *//*
	public static void  throwSystemException(Exchange exchange,String key)
	{
		final String methodName = "throwSystemException(Exchange exchange,String key)";
		LOG.debug("START: " + methodName );
		String value=MessageServiceUtil.getMessage(key);
		LOG.debug("value: "  +value);
		TNManagementServiceFault customerServiceFault= getFault(key,value);
		exchange.getOut().setFault(true);
		exchange.getOut().setBody(customerServiceFault);
		logError(customerServiceFault,exchange);
		logPerformanceStats(exchange);
		LOG.debug("END: " + methodName );
	}

	*//**
	 * This method constructs an application exception using message from down stream systems and sets the fault in the exchange 
	 * @param exchange
	 * @param key
	 * @param objArray
	 *//*
	public static void  throwApplicationException(Exchange exchange,TNManagementServiceFault wbFault,TNManagementServiceFault  cenFault)
	{
		final String methodName = "throwApplicationException(Exchange exchange,TNManagementServiceFault wbFault,TNManagementServiceFault  cenFault)";
		LOG.debug("START: " + methodName );
		TNManagementServiceFault ccsFault;
		com.comcast.xml.types.ExceptionType serviceFault= new ExceptionType();
		MessagesType messages=new MessagesType();
		MessageType[] values=new MessageType[2];

		serviceFault.setMessages(messages);

		int count=0;
		if(wbFault!=null)
		{
			MessageType wbmsg =new MessageType();
			MessageType msg = wbFault.getFaultInfo().getMessages().getMessage()[0];
			wbmsg.setCode(msg.getCode());
			wbmsg.setText(msg.getText());
			values[count]=wbmsg;

			
		}
		if(cenFault!=null)
		{
			count++;
			MessageType cenmsg = new MessageType();
			MessageType msg = cenFault.getFaultInfo().getMessages().getMessage()[0];
			cenmsg.setCode(msg.getCode());
			cenmsg.setText(msg.getText());
			values[count]=cenmsg;

		}
		messages.setMessage(values);
		ccsFault=new TNManagementServiceFault(Constants.ERROR,serviceFault);
		exchange.getOut().setFault(true);
		exchange.getOut().setBody(ccsFault);
		logError(ccsFault,exchange);
		logPerformanceStats(exchange);
		LOG.debug("END: " + methodName );

	}
	*//**
	 * This method construct the CommercialCustomerServiceFault with given error code and message
	 * @param code
	 * @param text
	 * @return
	 *//*

	public static TNManagementServiceFault getFault(String code,String text)
	{

		com.comcast.xml.types.ExceptionType serviceFault= new ExceptionType();
		MessagesType messages=new MessagesType();
		MessageType[] values=new MessageType[1];
		MessageType messageType=new MessageType();
		messageType.setCode(code);
		messageType.setText(text);
		values[0]=messageType;
		messages.setMessage(values);
		serviceFault.setMessages(messages);
		return new TNManagementServiceFault(Constants.ERROR,serviceFault);
		 
	}

	
	
	*//**
	 * This method construct the CommercialCustomerServiceFault with given error code and message
	 * @param code
	 * @param text
	 * @return
	 *//*

	public static TNManagementServiceFault getwbFault(String code,String text)
	{
		final String methodName = "getwbFault";
		LOG.debug("START: " + methodName );
		com.comcast.xml.types.ExceptionType serviceFault= new com.comcast.xml.types.ExceptionType();
		com.comcast.xml.types.MessagesType messages=new com.comcast.xml.types.MessagesType();
		com.comcast.xml.types.MessageType[] values=new com.comcast.xml.types.MessageType[1];
		com.comcast.xml.types.MessageType messageType=new com.comcast.xml.types.MessageType();
		messageType.setCode(code);
		messageType.setText(text);
		values[0]=messageType;
		messages.setMessage(values);
		serviceFault.setMessages(messages);
		LOG.debug("END: " + methodName );
		return new TNManagementServiceFault(Constants.ERROR,serviceFault);
		
	}

	*//**
	 * This method constructs an application exceptions and sets the fault in the exchange
	 * 
	 * @param exchange
	 * @param key
	 *//*

	public static void  throwApplicationException(Exchange exchange,TNManagementServiceFault fault)
	{
		final String methodName = "throwApplicationException";
		LOG.debug("START: " + methodName );
		exchange.getOut().setFault(true);
		exchange.getOut().setBody(fault);
		logError(fault,exchange);
		logPerformanceStats(exchange);
		LOG.debug("END: " + methodName );
	}
	
	
	private static TNManagementServiceFault getServiceFault(List<String> keyList) {
		LOG.info("ExceptionThrower::getServiceFault()::enters");
		
		com.comcast.xml.types.ExceptionType serviceFault = new ExceptionType();		
		MessagesType messages = new MessagesType();		
		List<MessageType> messageTypeList = new ArrayList<MessageType>();
		
		String errorKey = null;
		for(String key : keyList) {
			MessageType messageType = new MessageType();			
						
			String text = null;
			if(key != null){
				String[] arrStr = key.split("#");
				
				errorKey = arrStr[0];
				
				if(arrStr.length > 1) {
					String errorValue = arrStr[1];
					text =  MessageServiceUtil.getMessage(errorKey, new Object[]{errorValue});
				} else{
					text = MessageServiceUtil.getMessage(errorKey);
				}				
			}
			
			String errorCode = errorKey;	
			messageType.setCode(errorCode);			
			messageType.setText(text);			
			messageTypeList.add(messageType);
		}

		MessageType[] values = new MessageType[messageTypeList.size()];		
		messageTypeList.toArray(values);		
		messages.setMessage(values);		
		serviceFault.setMessages(messages);		
		
		TNManagementServiceFault fault = new TNManagementServiceFault(
				Constants.ERROR, serviceFault);
		
		LOG.info("ExceptionThrower::getServiceFault()::exits");
		return fault;
	}

	public static void logPerformanceStats(Exchange exchange)
	{
		Monitor monitor=(Monitor) exchange.getProperty("monitor");
		if (monitor != null) {
			monitor.stop();
			//log.debug(monitor.toString());
			LOG.info("(Label=" + monitor.getLabel() + ",LastValue=" + monitor.getLastValue() + ",Hits="
					+ monitor.getHits() + ",Avg=" + monitor.getAvg() + ",Total=" + monitor.getTotal()
					+ ",Min=" + monitor.getMin() + ",Max=" + monitor.getMax() + ",Active="
					+ monitor.getActive() + ",Avg_Active=" + monitor.getAvgActive() + ",Max_Active="
					+ monitor.getMaxActive() + ",First_Access=" + monitor.getFirstAccess()
					+ ",Last_Access=" + monitor.getLastAccess() + ")");
		}
	}



	public static void logError(TNManagementServiceFault fault,Exchange exchange)
	{
		MessagesType messages = fault.getFaultInfo().getMessages();

		MessageType[] messagesTypes = messages.getMessage();
		for(MessageType msgType:messagesTypes)
		{
			if(msgType!=null)
			{
			LOG.error("[Camel:CommercialResourceManagementService] error occured : error code : "+msgType.getCode() + "   error msg : "+msgType.getText());
			}
		}

	

	}*/


}
