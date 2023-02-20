package stepdef;

import amfam.bdd.base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutoQuoteSteps extends BaseClass{

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
	public void insert_zipcode(String string) {
		getAQuotePage.insertZipCodeField("54115");
	}

	@When("click car lob button")
	public void click_car_lob_button() {
		getAQuotePage.clickCarLobBtn();
	}

	@When("click lets go button")
	public void click_lets_go_button() {
		getAQuotePage.clickLetsGoBtn();
	}

	@Then("verify address page title")
	public void verify_address_page_title() {
		addressPage.verifyAddressPageTitle("Verify your city and state");
	}


}
