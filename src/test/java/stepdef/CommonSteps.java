package stepdef;

import amfam.bdd.base.BaseClass;
import amfam.bdd.reporting.Logs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps extends BaseClass{

	@Given("this is a quote test")
	public void this_is_a_quote_test() {
		Logs.log("*** This is a background step ***");
	}
	
	@Given("validating landing page title")
	public void validating_landing_page_title() {
		landingPage.validateLandingPageTitle("Insurance designed with you in mind");
	}
	
	@When("click start quote button")
	public void click_start_quote_button() {
		landingPage.clickStartNewQuoteBtn();
	} 
	
	@Then("validate get quote page title")
	public void validate_get_quote_page_title() {
		getAQuotePage.validateGetAQuotePageTitle("Get a Quote");
	}

	@When("insert zipcode {string}")
	public void insert_zipcode(String zipcode) {
		char appenderChar = zipcode.charAt(zipcode.length()-1);
		int appender = Integer.parseInt(String.valueOf(appenderChar)) -1;
		String zip = getData().get(appender).get(zipcode);
		Logs.log("--------> Zip Code is : "+zip);
		getAQuotePage.insertZipCodeField(zip);
	}
}
