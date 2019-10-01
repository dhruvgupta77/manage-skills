package com.nhs.skills.endpoints;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(MockitoJUnitRunner.class)
public class SkillsEndpointAddSkillTest extends SkillsEndpointTest {
	@Test
	public void shouldReturn201WhenSuccessfulForAddSkillRequest() throws Exception {
		mvc.perform(buildRequest(getValidSkillSet())).andExpect(status().isCreated());
	}

	@Test
	public void shouldReturn400WhenRequestIsInvalid() throws Exception {
		mvc.perform(buildRequest(null)).andExpect(status().isBadRequest());

	}

//	@Test
//	public void shouldReturn422WhenBusinessErrorIsEncountered() throws Exception {
//		doThrow(new NoRecordFoundException()).when(mockSkillsService).addNewSkillsToEmployee(any(String.class),
//				any(Set.class));
//		mvc.perform(buildRequest(getValidSkillSet())).andExpect(status().isUnprocessableEntity());
//	}
//
//	@Test
//	public void shouldReturn500WhenUnexpectedErrorIsEncountered() throws Exception {
//		doThrow(new RuntimeException()).when(mockSkillsService).addNewSkillsToEmployee(eq(employeeId), any(Set.class));
//		mvc.perform(buildRequest(getValidSkillSet())).andExpect(status().isUnprocessableEntity());
//
//	}

	@Override
	protected MockHttpServletRequestBuilder createRequestBuilder() {
		return post("/employeeSkills/{employeeId}/skills", employeeId);
	}

}
