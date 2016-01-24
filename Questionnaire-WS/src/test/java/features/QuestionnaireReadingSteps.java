package features;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.cavalier.questionnaire.back.model.Question;
import com.cavalier.questionnaire.back.service.reader.ExcelReader;
import com.cavalier.questionnaire.back.utils.QuestionnaireValidator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QuestionnaireReadingSteps {
	
	
	private ExcelReader  excelReader = new ExcelReader();;
	
	private List<Question>  questionsList = new ArrayList<Question>();
	
	private String fileUrl ;
	
	@Given("^an properly formatted excel file \"([^\"]*)\"$")
	public void an_properly_formatted_excel_file(String fileUrl) throws Throwable {
	    QuestionnaireValidator.validateFileFormat(fileUrl);
	    
	}


	@When("^the user import the file$")
	public void the_user_import_the_file() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
/*		fileUrl = this.getClass().getClassLoader().getResource("Questionnaire.csv").getPath();
		System.out.println("file : "+fileUrl);*/
		questionsList = excelReader.parseFile("/home/malika/sources/Questionnaire/Questionnaire-WS/src/test/resources/Questionnaire.csv");
		Assert.assertNotNull(questionsList);
	}

	@Then("^the questions are correctly imported$")
	public void the_questions_are_correctly_imported() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertFalse(CollectionUtils.isEmpty(questionsList));
	}
	
}
