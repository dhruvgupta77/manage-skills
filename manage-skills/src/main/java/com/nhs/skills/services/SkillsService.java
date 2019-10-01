package com.nhs.skills.services;

import java.util.List;
import java.util.Set;

import com.nhs.skills.errors.ApplicationException;
import com.nhs.skills.requests.Employee;
import com.nhs.skills.responses.EmployeeSkills;

public interface SkillsService {

	List<Employee> retrieveAllEmployee() throws ApplicationException;

	Employee retrieveEmployeeSkills(String maskedEmployeeId) throws ApplicationException;
	
	void addNewSkillsToEmployee(String employeeId, Set<EmployeeSkills> skills) throws ApplicationException;

	void updateSkillsToEmployee(String employeeId, Set<EmployeeSkills> skills) throws ApplicationException;
	
	void deleteSkillsForEmployee(String employeeId, Set<EmployeeSkills> skills) throws ApplicationException;

}
