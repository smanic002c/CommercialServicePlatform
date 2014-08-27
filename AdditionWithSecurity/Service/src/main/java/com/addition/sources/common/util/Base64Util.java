package com.addition.sources.common.util;

import org.apache.commons.codec.binary.Base64;
/**
 * This util class is used to encode and decode a String input
 * 
 */
public class Base64Util {

	private Base64Util() {}

	/**
	 * This method encodes the String data as per Base64 method
	 * @param data
	 * @return
	 */
	public static String encode(String data) {
		if (data == null) {
			return null;
		}
		
		byte[] dataBytes = data.getBytes();

		return new String(Base64.encodeBase64(dataBytes));
		
	}

	/**
	 * This method decodes the encoded String data as per Base64 method
	 * @param data
	 * @return
	 */
	public static String decode(String data) {
		if (data == null) {
			return null;
		}
		byte[] dataBytes = Base64.decodeBase64(data.getBytes());
		
		return new String(dataBytes);
	}


}
