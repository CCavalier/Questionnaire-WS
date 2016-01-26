package features;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.springframework.util.CollectionUtils;

import com.cavalier.questionnaire.back.exception.IncorrectFileException;
import com.cavalier.questionnaire.back.model.Question;
import com.cavalier.questionnaire.back.service.reader.ExcelReader;
import com.cavalier.questionnaire.back.utils.QuestionnaireValidator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class QuestionnaireReadingSteps {
	
	
	private ExcelReader  excelReader = new ExcelReader();;
	
	private List<Question>  questionsList = new ArrayList<Question>();
	
	private Exception exceptionCatched;

	private URL fileUrl;

	
	@Given("^an properly formatted excel file \"([^\"]*)\"$")
	public void an_properly_formatted_excel_file(String url) throws Throwable {
		URL completeUrl = this.getClass().getClassLoader().getResource(url);
	    QuestionnaireValidator.validateFileFormat(completeUrl.getPath());
	    this.fileUrl = completeUrl;
	    
	}

	@Given("^an poorly formatted excel file \"([^\"]*)\"$")
	public void an_poorly_formatted_excel_file(String url) throws Throwable {
		URL completeUrl = this.getClass().getClassLoader().getResource(url);
		try{
			QuestionnaireValidator.validateFileFormat(completeUrl.getPath());
		}catch(IncorrectFileException e){
			exceptionCatched = e;
		}
	}

	@When("^the user import the file$")
	public void the_user_import_the_file() throws Throwable {
		if(null == exceptionCatched){
			questionsList = excelReader.parseFile(fileUrl.getPath());
			Assert.assertNotNull(questionsList);
		}		
	}

	@Then("^the questions are correctly imported$")
	public void the_questions_are_correctly_imported() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertFalse(CollectionUtils.isEmpty(questionsList));
	}
	
	@Then("^an incorrect format exception is thrown$")
	public void an_incorrect_format_exception_is_thrown() throws Throwable {
	    Assert.assertTrue(exceptionCatched instanceof IncorrectFileException);
	}
	
}
