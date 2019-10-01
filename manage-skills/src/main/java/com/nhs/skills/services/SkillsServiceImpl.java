package com.nhs.skills.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nhs.skills.errors.ApplicationException;
import com.nhs.skills.errors.NoRecordFoundException;
import com.nhs.skills.requests.Employee;
import com.nhs.skills.responses.EmployeeSkills;
import com.nhs.skills.responses.SkillLevel;
import com.nhs.skills.responses.Skills;

@Service
public class SkillsServiceImpl implements SkillsService {

	private static final Logger LOG = LogManager.getLogger(SkillsServiceImpl.class);

	// Map to store employee data, ideally we should use database
	private Map<String, Employee> empData = new HashMap<String, Employee>();

	{		
		Set<EmployeeSkills> employee1Skills = new HashSet<EmployeeSkills>();
		employee1Skills.add(new EmployeeSkills(Skills.JAVA, SkillLevel.EXPERT));
		
		Set<EmployeeSkills> employee2Skills = new HashSet<EmployeeSkills>();
		employee2Skills.add(new EmployeeSkills(Skills.SCALA, SkillLevel.AWARENESS));
		
		Employee employee1 = new Employee("A101", "Dave", null, "Brown", employee1Skills);
		Employee employee2 = new Employee("A102", "John", null, "Wilson", employee2Skills);
		empData.put(employee1.getEmployeeId(), employee1);
		empData.put(employee2.getEmployeeId(), employee2);

	}

	@Override
	public List<Employee> retrieveAllEmployee() throws ApplicationException {
		return empData.values().stream().collect(Collectors.toCollection(ArrayList::new));
	}
	
	@Override
	public Employee retrieveEmployeeSkills(String employeeId) throws ApplicationException {
		LOG.traceEntry(employeeId);		
		return LOG.traceExit(getEmployee(employeeId));
	}

	@Override
	public void addNewSkillsToEmployee(String employeeId, Set<EmployeeSkills> skills) throws ApplicationException {
		LOG.traceEntry(employeeId);
		getEmployee(employeeId).getSkills().addAll(skills);
		LOG.traceExit();
	}

	@Override
	public void updateSkillsToEmployee(String employeeId, Set<EmployeeSkills> skills) throws ApplicationException {
		LOG.traceEntry(employeeId);
		Set<EmployeeSkills> empSkills = getEmployee(employeeId).getSkills();
		if(!empSkills.containsAll(skills)) 
			throw new NoRecordFoundException();
		empSkills.removeAll(skills);
		empSkills.addAll(skills);
		LOG.traceExit();
	}	

	@Override
	public void deleteSkillsForEmployee(String employeeId, Set<EmployeeSkills> skills) throws ApplicationException {
		LOG.traceEntry(employeeId);
		Set<EmployeeSkills> empSkills = getEmployee(employeeId).getSkills();
		if(!empSkills.containsAll(skills)) 
			throw new NoRecordFoundException();
		empSkills.removeAll(skills);		
		LOG.traceExit();
	}
	
	private Employee getEmployee(String employeeId) throws NoRecordFoundException {
		Employee employee = empData.get(employeeId);
		if (employee == null) 
			throw new NoRecordFoundException();
		return employee;
	}

}
