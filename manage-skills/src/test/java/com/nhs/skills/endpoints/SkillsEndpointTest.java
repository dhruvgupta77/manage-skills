package com.nhs.skills.endpoints;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhs.skills.responses.EmployeeSkills;
import com.nhs.skills.responses.SkillLevel;
import com.nhs.skills.responses.Skills;
import com.nhs.skills.services.SkillsService;

public abstract class SkillsEndpointTest {

	protected String employeeId = "employeeId";

	@Mock
	protected SkillsService mockSkillsService;

	protected ObjectMapper objectMapper;

	protected MockMvc mvc;

	@Before
	public void setUp() {
		objectMapper = new Jackson2ObjectMapperBuilder().failOnUnknownProperties(false).build();
		mvc = MockMvcBuilders.standaloneSetup(new SkillsEndpoint(mockSkillsService))
				.setMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper)).build();
	}

	protected MockHttpServletRequestBuilder buildRequest(Set<EmployeeSkills> employeeSkills)
			throws JsonProcessingException {
		String jsonRequest = objectMapper.writeValueAsString(employeeSkills);
		return createRequestBuilder().content(jsonRequest).contentType(MediaType.APPLICATION_JSON);
	}

	protected Set<EmployeeSkills> getValidSkillSet() {
		Set<EmployeeSkills> employeeSkills = new HashSet<EmployeeSkills>();
		employeeSkills.add(new EmployeeSkills(Skills.JAVA, SkillLevel.EXPERT));
		employeeSkills.add(new EmployeeSkills(Skills.AWS, SkillLevel.AWARENESS));
		employeeSkills.add(new EmployeeSkills(Skills.GRADLE, SkillLevel.PRACTITIONER));
		employeeSkills.add(new EmployeeSkills(Skills.JSF, SkillLevel.WORKING));
		employeeSkills.add(new EmployeeSkills(Skills.PLSQL, SkillLevel.EXPERT));
		return employeeSkills;
	}

	protected abstract MockHttpServletRequestBuilder createRequestBuilder();

}
