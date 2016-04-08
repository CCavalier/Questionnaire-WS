package com.cavalier.questionnaire.back.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cavalier.questionnaire.back.dao.QuestionnaireDao;
import com.cavalier.questionnaire.back.dao.UserDao;
import com.cavalier.questionnaire.back.exception.UserAlreadyExistsException;
import com.cavalier.questionnaire.back.model.Question;

@RestController
@RequestMapping("/test")
public class QuestionnaireRestService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private QuestionnaireDao questionnaireDao;

	@RequestMapping(value = "/askTest", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<Question> askForTest(@RequestParam String login) throws UserAlreadyExistsException {
		userDao.create(login);
		return questionnaireDao.getQuestionList();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public QuestionnaireDao getQuestionnaireDao() {
		return questionnaireDao;
	}

	public void setQuestionnaireDao(QuestionnaireDao questionnaireDao) {
		this.questionnaireDao = questionnaireDao;
	}

}
