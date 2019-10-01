package com.nhs.skills.errors;

public class NoRecordFoundException extends ApplicationException {

	private static final long serialVersionUID = 2308382892909569184L;

	public NoRecordFoundException() {
		super(ErrorCode.NO_RECORD_FOUND, null);
	}
}