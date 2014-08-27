package com.addition.sources.common.exception;

import java.util.List;

public class ValidationExceptionThrower {

	public void throwException(String sMessage) throws Exception {
		throw new ValidationException(sMessage);
	}

	public void throwException(List<String> list) throws Exception {
		throw new ValidationException(list);
	}

}
