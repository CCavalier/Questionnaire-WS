Feature: User Action
  After login a user receive a lot of questions and can answer to these.
 
  Scenario: Login.
  	Given I give a new identifier
  	When I connect to the test
  	Then a lot of questions are proposed to me
  	
 Scenario: My identifier is already used
  	Given I give an already used identifier
  	When I connect to the test
  	Then an exception is sent
  	
  Scenario: I didn't give identifier
  	Given I give no identifier
  	When I connect to the test
  	Then an exception is sent 	
 
 Scenario: Answer to a question
  	Given I answer to a question
  	When I submit it
  	Then my answer is kept in the application
  	
 Scenario: Submit the questionnaire
 	Given I finished my questionnaire
 	When I submit my questionnaire
 	Then my results are computed
 	And I can see them
 	And they are saved
  	 	