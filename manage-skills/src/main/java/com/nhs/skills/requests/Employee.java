package com.nhs.skills.requests;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nhs.skills.responses.EmployeeSkills;

@JsonInclude(Include.NON_NULL)
public class Employee {

	@NotNull
	private final String employeeId;
	@NotNull
	private final String firstName;

	private final String middleName;

	@NotNull
	private final String surname;

	@NotNull
	private Set<EmployeeSkills> skills;

	@JsonCreator
	public Employee(@NotNull @JsonProperty(value = "employeeId") String employeeId,
			@NotNull @JsonProperty(value = "firstName") String firstName,
			@JsonProperty(value = "middleName") String middleName,
			@NotNull @JsonProperty(value = "surname") String surname,
			@NotNull @JsonProperty(value = "skills") Set<EmployeeSkills> skills) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.surname = surname;
		this.skills = skills;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getSurname() {
		return surname;
	}

	public Set<EmployeeSkills> getSkills() {
		return skills;
	}
	
	public void setSkills(Set<EmployeeSkills> skills) {
		this.skills = skills;
	}
	

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("employeeId", employeeId).append("firstName", firstName)
				.append("middleName", middleName).append("surname", surname).append("skills", skills).toString();
	}

}
