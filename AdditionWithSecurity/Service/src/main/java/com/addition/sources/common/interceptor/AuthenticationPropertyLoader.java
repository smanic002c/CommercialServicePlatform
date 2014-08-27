package com.addition.sources.common.interceptor;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.addition.sources.common.util.Base64Util;

public class AuthenticationPropertyLoader {
	private static Logger logger = Logger.getLogger(AuthenticationPropertyLoader.class);

	public static final Map<String, String> CREDENTIALMAP = new HashMap<String, String>();
	private String credentials;

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		logger.debug("AuthenticationPropertyLoader::setCredentials()::enters");
		this.credentials = credentials;
		loadMap(credentials);
		logger.debug("AuthenticationPropertyLoader::setCredentials()::exits");
	}

	public static void loadMap(String credentials) {
		String[] value = credentials.split(":");
		for (String child : value) {
			String usrpwd[] = child.split("~");
			CREDENTIALMAP.put(usrpwd[0].trim(), Base64Util.decode(usrpwd[1].trim()));
		}
	}

}
