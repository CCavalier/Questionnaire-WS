package com.cavalier.questionnaire.back.service.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cavalier.questionnaire.back.dao.QuestionnaireDao;
import com.cavalier.questionnaire.back.dao.UserDao;
import com.cavalier.questionnaire.back.model.Question;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-context.xml")
// @SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
// @RunWith(MockitoJUnitRunner.class)
public class QuestionnaireRestServiceTest {

	@Autowired
	@InjectMocks
	private QuestionnaireRestService questionnaireRestService;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));

	@Mock
	QuestionnaireDao questionnaireDao;

	@Mock
	UserDao userDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void askForATest() throws JsonProcessingException, Exception {
		// given
		List<Question> questionList = new ArrayList<Question>();
		Question test = new Question();
		test.setText("question");
		questionList.add(test);
		when(questionnaireDao.getQuestionList()).thenReturn(questionList);
		// when
		MvcResult result = mockMvc.perform(post("/test/askTest")
				.contentType(contentType)
				.param("login", "toto"))
				.andReturn();
		// then
		String jsonList = result.getResponse().getContentAsString();
		Assert.assertNotNull(jsonList);
		Assert.assertEquals("[{\"text\":\"question\",\"answers\":null,\"solution\":null}]",
				jsonList);

	}

	protected String json(Object o) throws JsonProcessingException {
		ObjectMapper test = new ObjectMapper();
		return test.writeValueAsString(o);
	}

	public QuestionnaireRestService getQuestionnaireRestService() {
		return questionnaireRestService;
	}

	public void setQuestionnaireRestService(QuestionnaireRestService questionnaireRestService) {
		this.questionnaireRestService = questionnaireRestService;
	}

	public MockMvc getMockMvc() {
		return mockMvc;
	}

	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}

	public WebApplicationContext getWebApplicationContext() {
		return webApplicationContext;
	}

	public void setWebApplicationContext(WebApplicationContext webApplicationContext) {
		this.webApplicationContext = webApplicationContext;
	}

	public MediaType getContentType() {
		return contentType;
	}

	public void setContentType(MediaType contentType) {
		this.contentType = contentType;
	}

	public QuestionnaireDao getQuestionnaireDao() {
		return questionnaireDao;
	}

	public void setQuestionnaireDao(QuestionnaireDao questionnaireDao) {
		this.questionnaireDao = questionnaireDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
