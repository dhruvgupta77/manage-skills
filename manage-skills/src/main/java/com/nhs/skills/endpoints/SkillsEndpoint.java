package com.nhs.skills.endpoints;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhs.skills.errors.ApplicationException;
import com.nhs.skills.requests.Employee;
import com.nhs.skills.responses.EmployeeSkills;
import com.nhs.skills.services.SkillsService;

@RestController
@RequestMapping("/employeeSkills")
public class SkillsEndpoint {

	private static final Logger LOG = LogManager.getLogger(SkillsEndpoint.class);
	private final SkillsService skillsService;

	@Autowired
	public SkillsEndpoint(SkillsService skillsService) {
		this.skillsService = skillsService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAllEmployeeSkillDetails() throws ApplicationException {
		LOG.traceEntry();
		List<Employee> employees = skillsService.retrieveAllEmployee();
		return LOG.traceExit(new ResponseEntity<>(employees, HttpStatus.OK));
	}

	@GetMapping(value = "/{employeeId}/skills", 
			    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeSkillDetails(@PathVariable final String employeeId)
			throws ApplicationException {
		LOG.traceEntry(employeeId);
		Employee employee = skillsService.retrieveEmployeeSkills(employeeId);
		return LOG.traceExit(new ResponseEntity<>(employee, HttpStatus.OK));
	}

	@PostMapping(value = "/{employeeId}/skills", 
			     produces = MediaType.APPLICATION_JSON_VALUE, 
			     consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> addSkillToEmployee(@PathVariable final String employeeId,
			@Valid @RequestBody Set<EmployeeSkills> skills) throws ApplicationException {
		LOG.traceEntry(employeeId);
		skillsService.addNewSkillsToEmployee(employeeId, skills);
		return LOG.traceExit(ResponseEntity.status(HttpStatus.CREATED).build());
	}

	@PutMapping(value = "/{employeeId}/skills", 
				produces = MediaType.APPLICATION_JSON_VALUE, 
				consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateSkillToEmployee(@PathVariable final String employeeId,
			@Valid @RequestBody Set<EmployeeSkills> skills) throws ApplicationException {
		LOG.traceEntry(employeeId);
		skillsService.updateSkillsToEmployee(employeeId, skills);
		return LOG.traceExit(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
	}
	
	@DeleteMapping(value = "/{employeeId}/skills",
			       consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteSkillToEmployee(@PathVariable final String employeeId,
			@Valid @RequestBody Set<EmployeeSkills> skills) throws ApplicationException {
		LOG.traceEntry(employeeId);
		skillsService.deleteSkillsForEmployee(employeeId, skills);
		return LOG.traceExit(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
	}
}