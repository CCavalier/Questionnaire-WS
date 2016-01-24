package com.cavalier.questionnaire.back.service.reader;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.cavalier.questionnaire.back.model.Answer;
import com.cavalier.questionnaire.back.model.Question;

public class ExcelReaderTest {

	private ExcelReader  excelReader = new ExcelReader();
	
	@Test
	public void parseFileTest() throws IOException{
	 URL url = this.getClass().getClassLoader().getResource("Questionnaire.csv");
	 Assert.assertNotNull(url);
	 List<Question> parsedList = excelReader.parseFile(url.getPath());
	 Assert.assertNotNull(parsedList);
	 Assert.assertEquals(1, parsedList.size());
	 for(Question questionRead : parsedList){
		 Assert.assertEquals("Qwerty", questionRead.getText());
		 Assert.assertNotNull(questionRead.getAnswers());
		 Assert.assertFalse(questionRead.getAnswers().isEmpty());
		 Assert.assertTrue(questionRead.getSolution().contains("POI"));
		 Assert.assertEquals(1, questionRead.getSolution().size());
	 }
	 
		
	}
	
	@Test(expected = IOException.class)
	public void parseFileTestFail() throws IOException{
		excelReader.parseFile("azzerty");
	}
	
	@Test
	public void initAnswerTest(){
		Answer  answer = excelReader.initAnswer("test");
		Assert.assertEquals("test", answer.getText());
		Assert.assertFalse(answer.isValue());
		
	}
}
