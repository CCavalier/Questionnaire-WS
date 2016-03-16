package com.cavalier.questionnaire.back.utils;

import java.io.IOException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import com.cavalier.questionnaire.back.exception.IncorrectFileException;

public class QuestionnaireValidatorTest {
	
	/**
	 * test for a correctly formatted file
	 * @throws IncorrectFileException 
	 * @throws IOException 
	 */
	@Test
	public void validateFileOk() throws IncorrectFileException, IOException{
		URL url = this.getClass().getClassLoader().getResource("Questionnaire.csv");
		QuestionnaireValidator.validateFileFormat(url.getPath());
	}
	
	
	/**
	 * @throws IncorrectFileException 
	 * @throws IOException 
	 * 
	 */
	@Test(expected= IncorrectFileException.class)
	public void validateFileKo() throws IncorrectFileException, IOException{
		URL url = this.getClass().getClassLoader().getResource("BadQuestionnaire.csv");
		QuestionnaireValidator.validateFileFormat(url.getPath());
	}
	
	/**
	 * test for verify line
	 */
	@Test
	public void verifyLineTest(){
		String[] values ={"java","hasdh ahsdhasd asd","","","","","4"};
		boolean isOk =QuestionnaireValidator.verifyLine(values);
		Assert.assertTrue(isOk);
		String[] valuestwo ={"--","hasdh ahsdhasd asd","","","","","4"};
		isOk =QuestionnaireValidator.verifyLine(valuestwo);
		Assert.assertFalse(isOk);
		String[] valuesThree ={"java","5","","","","","4"};
		isOk =QuestionnaireValidator.verifyLine(valuesThree);
		Assert.assertFalse(isOk);
		//trop complique
//		String[] valuesFour={"java","aaaa","","","","","4"};
//		isOk =QuestionnaireValidator.verifyLine(valuesFour);
//		Assert.assertFalse(isOk);
		String[] valuesFive={"java","hasdh ahsdhasd asd","","","","","qwe"};
		isOk =QuestionnaireValidator.verifyLine(valuesFive);
		Assert.assertFalse(isOk);
	}

}
