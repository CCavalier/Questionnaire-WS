package com.cavalier.questionnaire.back.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cavalier.questionnaire.back.model.Question;

@Component
public class QuestionnaireDao {

	public List<Question> getQuestionList() {
		List<Question> questionList = new ArrayList<>();
		Question q1 = new Question();
		q1.setText("My awesome question");
		questionList.add(q1);
		return questionList;
		// TODO call the database or load the question list

	}

}
