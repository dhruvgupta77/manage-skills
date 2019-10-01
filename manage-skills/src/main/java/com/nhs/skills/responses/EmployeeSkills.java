package com.nhs.skills.responses;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeSkills {

	private final Skills skill;
	private final SkillLevel level;

	@JsonCreator
	public EmployeeSkills(@JsonProperty("skill") Skills skill, @JsonProperty("level") SkillLevel level) {
		super();
		this.skill = skill;
		this.level = level;
	}

	public Skills getSkill() {
		return skill;
	}

	public SkillLevel getLevel() {
		return level;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("skill", skill).append("level", level).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeSkills other = (EmployeeSkills) obj;
		if (skill != other.skill)
			return false;
		return true;
	}

	
}
