package com.cavalier.questionnaire.back.model;

import java.util.List;

/**
 * Data model for question
 * a question is composed with a question text, many assertions which can be true or false
 */
public class Question {

	/**
	 * question text
	 */
	private String text;
	
	/**
	 * set of answers which can be chosen, and their expected values
	 */
	private List<Answer> answers;
	
	private List<String> solution;
	
	
	public List<String> getSolution() {
		return solution;
	}
	public void setSolution(List<String> solution) {
		this.solution = solution;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
		result = prime * result + ((solution == null) ? 0 : solution.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		if (solution == null) {
			if (other.solution != null)
				return false;
		} else if (!solution.equals(other.solution))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
}
