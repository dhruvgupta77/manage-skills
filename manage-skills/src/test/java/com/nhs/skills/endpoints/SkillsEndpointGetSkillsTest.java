package com.nhs.skills.endpoints;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.nhs.skills.requests.Employee;
import com.nhs.skills.responses.EmployeeSkills;
import com.nhs.skills.responses.SkillLevel;
import com.nhs.skills.responses.Skills;

@RunWith(MockitoJUnitRunner.class)
public class SkillsEndpointGetSkillsTest extends SkillsEndpointTest {

	@Test
	public void testGetEmployeeSkillOkResult() throws Exception {
		Set<EmployeeSkills> employee1Skills = new HashSet<EmployeeSkills>();
		employee1Skills.add(new EmployeeSkills(Skills.JAVA, SkillLevel.EXPERT));
		employee1Skills.add(new EmployeeSkills(Skills.SCALA, SkillLevel.EXPERT));

		Employee employee = new Employee(employeeId, "Dave", null, "Brown", employee1Skills);

		when(mockSkillsService.retrieveEmployeeSkills(employeeId)).thenReturn(employee);
		mvc.perform(createRequestBuilder()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
				.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(employee)));

	}

	@Test
	public void testGetAllEmployeesOkResult() throws Exception {
		employeeId = null;
		mvc.perform(createRequestBuilder()).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGetEmployeeSkillKoResult() throws Exception {
		employeeId = null;
		mvc.perform(get("/employeeSkills/{employeeId}/skills", employeeId))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Override
	protected MockHttpServletRequestBuilder createRequestBuilder() {
		return get(getUrl(employeeId), employeeId);
	}

	private String getUrl(String employeeId) {
		final String url;
		if (null == employeeId) {
			url = "/employeeSkills";
		} else {
			url = "/employeeSkills/{employeeId}/skills";
		}
		return url;
	}

}
