package features;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cavalier.questionnaire.back.model.Question;
import com.cavalier.questionnaire.back.service.rest.QuestionnaireRestService;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * I still have no idea how to inject my fucking dependencies
 * 
 * @see http://stackoverflow.com/questions/23564938/can-i-use-spring-to-autowire
 *      -controller-in-cucumber-test
 * @author ccavalie
 *
 */
@ContextConfiguration("classpath:cucumber.xml")
public class UserActionSteps {

	private String login;

	@Autowired
	private QuestionnaireRestService questionnaireService;

	private List<Question> questionList;

	@Given("^I give a new identifier$")
	public void i_give_a_new_identifier() throws Throwable {
		login = "Azerty";
	}

	@When("^I connect to the test$")
	public void i_connect_to_the_test() throws Throwable {
		questionList = questionnaireService.askForTest(login);
	}

	@Then("^a lot of questions are proposed to me$")
	public void a_lot_of_questions_are_proposed_to_me() throws Throwable {
		Assert.assertNotNull(questionList);
		Assert.assertFalse(questionList.isEmpty());
	}

	@Given("^I give an already used identifier$")
	public void i_give_an_already_used_identifier() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^an exception is sent$")
	public void an_exception_is_sent() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^I give no identifier$")
	public void i_give_no_identifier() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^I answer to a question$")
	public void i_answer_to_a_question() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I submit it$")
	public void i_submit_it() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^my answer is kept in the application$")
	public void my_answer_is_kept_in_the_application() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^I finished my questionnaire$")
	public void i_finished_my_questionnaire() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I submit my questionnaire$")
	public void i_submit_my_questionnaire() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^my results are computed$")
	public void my_results_are_computed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I can see them$")
	public void i_can_see_them() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^they are saved$")
	public void they_are_saved() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
