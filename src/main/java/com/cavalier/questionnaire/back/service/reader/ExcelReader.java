package com.cavalier.questionnaire.back.service.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cavalier.questionnaire.back.exception.IncorrectFileException;
import com.cavalier.questionnaire.back.model.Answer;
import com.cavalier.questionnaire.back.model.Question;
import com.cavalier.questionnaire.back.utils.QuestionnaireValidator;
import com.opencsv.CSVReader;

public class ExcelReader {

	public List<Question> parseFile(String url) throws IOException, IncorrectFileException {
		List<Question> questions = new ArrayList<Question>();
		QuestionnaireValidator.validateFileFormat(url);
		CSVReader reader = new CSVReader(new FileReader(url));
		boolean firstLine = true;
		String[] nextLine;
		
		while ((nextLine = reader.readNext()) != null) {
			if (firstLine){
				/*ignore title line*/
				firstLine = false;
				
			}else{
			
				Question question = new Question();
				question.setText(nextLine[1]);
				questions.add(question);
				/*init answer list */
				List<Answer> answers = new ArrayList<Answer>();
				answers.add(initAnswer(nextLine[2]));
				answers.add(initAnswer(nextLine[3]));
				answers.add(initAnswer(nextLine[4]));
				answers.add(initAnswer(nextLine[5]));
				question.setAnswers(answers);
				/*init solution*/
				List<String> solution = new ArrayList<String>();
				int value = Integer.parseInt(nextLine[6]) - 1;//previous columns plus one
				solution.add(answers.get(value).getText());
				question.setSolution(solution);
			}
			// nextLine[] is an array of values from the line
		}
		
		reader.close();
	
		return questions;

		/*
		 * throw new NotImplementedException(
		 * "ExcelReader parsefile not implemented yet");
		 */
	}

	/**
	 * generate an answer from a string
	 * @param string
	 * @return
	 */
	protected Answer initAnswer(String string) {
		Answer answer = new Answer();
		answer.setText(string);
		answer.setValue(false);
		return answer;
	}

}
