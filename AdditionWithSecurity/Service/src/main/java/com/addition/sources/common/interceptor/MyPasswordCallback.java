package com.addition.sources.common.interceptor;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.ws.security.WSPasswordCallback;

import com.addition.sources.common.constants.Constants;

/**
 * This class validates the input wsse username and password using callback
 * hanlder
 * 
 * @author cognizant
 * 
 */
public class MyPasswordCallback implements CallbackHandler {
	private static Logger logger = Logger.getLogger(MyPasswordCallback.class);

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		logger.debug("MyPasswordCallback::handle()::enters");

		WSPasswordCallback passwordCallback = (WSPasswordCallback) callbacks[0];
		String userName = passwordCallback.getIdentifier();

		String identifier = passwordCallback.getIdentifier();
		logger.info("MyPasswordCallback::handle()::identifier:" + identifier);

		if (identifier != null && !"".equals(identifier.trim())) {
			String password = AuthenticationPropertyLoader.CREDENTIALMAP.get(identifier);
			passwordCallback.setPassword(password);
		} else {
			passwordCallback.setPassword("invalidrequest");
		}

		try {
			// To get requested data - getRequestData()
//			org.apache.cxf.binding.soap.SoapMessage soapMessage = (SoapMessage) passwordCallback.getRequestData().getMsgContext();
//			org.apache.cxf.binding.soap.saaj.SAAJStreamWriter writer = (SAAJStreamWriter) soapMessage.get("org.apache.cxf.staxutils.W3CDOMStreamWriter");
//			NodeList childnodes = writer.getCurrentNode().getChildNodes();
//			Node requestHeaderNodes = getRequestHeaderNode(childnodes.item(0).getChildNodes());

			MDC.put(Constants.WS_USER_ID, userName);
			MDC.put(Constants.SERVICE_VERSION, Constants.VERSION);
			// MDC.put(SERVICE_VERSION, MODULE_VERSION_VALUE);

		} catch (Exception e) {
			logger.error("MyPasswordCallback::handle()::Error occured while retrieving the request header", e);
		}

	}

	/**
	 * Used to get request header node.
	 * 
	 * @param childnodes
	 *            Child nodes list.
	 * @return Returns request header node.
	 */
	/*private Node getRequestHeaderNode(NodeList childnodes) {
		logger.debug("MyPasswordCallback::getRequestHeaderNode()::Enters");
		org.w3c.dom.Node node = null;
		if (childnodes != null) {
			for (int i = 0; i < childnodes.getLength(); i++) {
				node = childnodes.item(i);
				if (Constants.REQUEST_HEADER.equals(node.getLocalName())) {
					break;
				}
			}
		}
		logger.debug("MyPasswordCallback::getRequestHeaderNode()::Exits");
		return node;
	}*/

	/**
	 * Used to get request header type.
	 * 
	 * @param requestHeader
	 *            Request header nodes list.
	 * @return Returns request header type.
	 */
	/*private com.comcast.xml.types.RequestHeaderType getRequestHeaderType(NodeList requestHeader) {
		logger.debug("MyPasswordCallback::getRequestHeaderType()::Enters");
		com.comcast.xml.types.RequestHeaderType headerType = new RequestHeaderType();
		org.w3c.dom.Node node = null;
		if (requestHeader != null) {
			for (int i = 0; i < requestHeader.getLength(); i++) {
				node = requestHeader.item(i);
				String localName = node.getLocalName();
				String value = node.getTextContent();

				setHeaderTypes(headerType, localName, value);
			}
		}
		logger.debug("MyPasswordCallback::getRequestHeaderType()::Exits");
		return headerType;
	}*/

	/*private void setHeaderTypes(com.comcast.xml.types.RequestHeaderType headerType, String localName, String value) {
		if (Constants.TIMESTAMP.equals(localName)) {
			try {
				GregorianCalendar gregorianCalendar = new GregorianCalendar();
				gregorianCalendar.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(value));
				headerType.setTimestamp(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar));
			} catch (ParseException e) {
				logger.error("MyPasswordCallback::getRequestHeaderType()::ParseException", e);
			} catch (DatatypeConfigurationException e) {
				logger.error("MyPasswordCallback::getRequestHeaderType()::DatatypeConfigurationException", e);
			}
		}
		if (Constants.SOURCE_SYSTEM_ID.equals(localName)) {
			headerType.setSourceSystemId(value);
		}
		if (Constants.SOURCE_SYSTEM_USER_ID.equals(localName)) {
			headerType.setSourceSystemUserId(value);
		}
		if (Constants.SOURCE_SERVER_ID.equals(localName)) {
			headerType.setSourceServerId(value);
		}
		if (Constants.TRACKING_ID.equals(localName)) {
			headerType.setTrackingId(value);
		}
	}*/

}
