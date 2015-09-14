package com.cavalier.questionnaire.back.service.reader;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import com.cavalier.questionnaire.back.model.Question;


public class ExcelReaderTest {
	
	private ExcelReader reader = new ExcelReader();
	
	private final static String url = "resources/excelText.xsls";

	@Test 
	public void readFileTest() throws FileNotFoundException{
		List<Question> questions =reader.parseFile(url);
		
		assertTrue(true);
	}
	
	@Test (expected=FileNotFoundException.class)
	public void readFileFailTest() throws FileNotFoundException{
		List<Question> questions =reader.parseFile(" ");
	}
	
}
