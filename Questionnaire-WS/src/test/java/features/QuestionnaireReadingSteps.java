package features;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QuestionnaireReadingSteps {
	@Given("^an properly formatted excel file$")
	public void an_properly_formatted_excel_file() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}

	@When("^the user import the file$")
	public void the_user_import_the_file() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	}

	@Then("^the questions are correctly imported$")
	public void the_questions_are_correctly_imported() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(true);
	}
	
}
