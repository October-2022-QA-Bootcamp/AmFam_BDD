package amfam.bdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import amfam.bdd.common.CommonActions;

public class GetAQuotePage {

	CommonActions actions;
	
	public GetAQuotePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new CommonActions(driver);
	}
	
	@FindBy(className = "h1")
	WebElement getAQuotePageTitle;
	@FindBy(id = "uid_61")
	WebElement zipCoddInput;
	@FindBy(xpath = "//div[@value='Car']")
	WebElement carLobBtn;
	@FindBy(xpath = "//div[@value='Home']")
	WebElement homeLobBtn;
	@FindBy(className = "LoadingButton__content")
	WebElement letsGoBtn;
	
	public void validateGetAQuotePageTitle(String expected) {
		actions.validate(getAQuotePageTitle, expected);
	}
	
	public void insertZipCodeField(String zip) {
		actions.insert(zipCoddInput, zip);
	}
	
	public void clickCarLobBtn() {
		actions.click(carLobBtn);
	}
	
	public void clickHomeLobBtn() {
		actions.click(homeLobBtn);
	}
	
	public void clickLetsGoBtn() {
		actions.click(letsGoBtn);
	}

}
