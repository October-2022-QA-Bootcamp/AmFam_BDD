package amfam.bdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import amfam.bdd.common.CommonActions;

public class LandingPage {

	CommonActions actions;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new CommonActions(driver);
	}
	
	@FindBy(tagName = "h1")
	WebElement landingPageTitle;
	@FindBy(xpath = "//button[normalize-space(text())='Start a New Quote']")
	WebElement startNewQuoteBtn;
	
	public void validateLandingPageTitle(String expectedTitle) {
		actions.validate(landingPageTitle, expectedTitle);
	}
	
	public void clickStartNewQuoteBtn() {
		actions.click(startNewQuoteBtn);
	}
}
