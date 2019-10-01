package com.nhs.skills.responses;

public enum Skills {
	JAVA("Java"), 
	PYTHON("Python"),
	SCALA("Scala"),
	RUBY("Ruby"),
	AWS("AWS"),
	SQL("SQL"),
	PLSQL("PLSQL"),
	MAVEN("Maven"),
	GRADLE("Gradle"),
	UNIX("Unix"),
	SPRING("Spring"),
	HIBERNATE("Hibernate"),
	JSF("JSF");	

	private String value;

	private Skills(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
