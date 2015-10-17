Feature: Questionnaire reading
  Allow the user to import its Excel file into the application.
 
  Scenario: Import an questionnaire excel file.
  	Given an properly formatted excel file "excelTest.xlsx"
  	When the user import the file
  	Then the questions are correctly imported
  	