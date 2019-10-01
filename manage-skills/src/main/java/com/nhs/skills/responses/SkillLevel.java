package com.nhs.skills.responses;

public enum SkillLevel {

	EXPERT("Expert"), 
	PRACTITIONER("Practitioner"), 
	WORKING("Working"), 
	AWARENESS("Awareness");

	private String value;

	private SkillLevel(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
