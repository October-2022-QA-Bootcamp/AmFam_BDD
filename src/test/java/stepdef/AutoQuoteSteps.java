package stepdef;

import amfam.bdd.base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutoQuoteSteps extends BaseClass{

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
