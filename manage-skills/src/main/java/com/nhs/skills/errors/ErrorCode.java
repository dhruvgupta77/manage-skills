package com.nhs.skills.errors;

public enum ErrorCode {

	NO_RECORD_FOUND(1001, "No record found");

	private final int id;
	private final String description;

	private ErrorCode(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
}
