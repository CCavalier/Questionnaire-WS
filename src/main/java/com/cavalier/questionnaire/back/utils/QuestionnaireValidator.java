package com.cavalier.questionnaire.back.utils;



import java.io.FileReader;
import java.io.IOException;

import com.cavalier.questionnaire.back.exception.IncorrectFileException;
import com.opencsv.CSVReader;

public class QuestionnaireValidator {

	/**
	 * open the file passed in parameters and verify its format is ok
	 * Header must follow [ExcelFileColums.java] and line must be coherent
	 * @param fileUrl
	 * @throws IncorrectFileException
	 * @throws IOException
	 */
	public static void validateFileFormat(String fileUrl) throws IncorrectFileException, IOException{
		System.out.println(fileUrl);
		CSVReader reader = new CSVReader(new FileReader(fileUrl));
		boolean firstLine = true;
		String[] nextLine;
		
		while ((nextLine = reader.readNext()) != null) {
			if (firstLine){
				for(int i = 0; i < ExcelFileColumns.EXCEL_COLUMNS.length; i++){
					if(!nextLine[i].trim().equals(ExcelFileColumns.EXCEL_COLUMNS[i])){
						throw new IncorrectFileException();
					}
				}
				firstLine = false;
			}else{
				boolean lineCorrect = verifyLine(nextLine);
				
				if(!lineCorrect){
					throw new IncorrectFileException();
				}

			}
			// nextLine[] is an array of values from the line
		}
		reader.close();
	}

	/**
	 * verifie le formalisme des lignes
	 * @param nextLine
	 * @return true if line is correct
	 */
	protected static boolean verifyLine(String[] nextLine) {
		boolean lineCorrect = true;
		//la premier colone est un mot
		lineCorrect  &= nextLine[0].matches("\\w+");
		// la deuxieme est une question
//		lineCorrect  &= nextLine[1].matches("[\\W* \\w*]+");
		lineCorrect &= nextLine[1].matches("[\\w+\\s*]{2,}");
		//la derniere est la reponse
		lineCorrect  &= nextLine[6].matches("[1-4]");
		return lineCorrect;
	}

}
