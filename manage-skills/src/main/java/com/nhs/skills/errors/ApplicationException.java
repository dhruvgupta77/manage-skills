package com.nhs.skills.errors;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 6614293204365003806L;
	private final ErrorCode errorCode;

	protected ApplicationException(ErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	@Override
	public String toString() {
		 return new ToStringBuilder(this)
			        .append("errorCode", errorCode)			        
			        .toString();
	}

	
}
