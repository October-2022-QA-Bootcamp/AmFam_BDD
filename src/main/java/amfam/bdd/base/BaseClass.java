package amfam.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static amfam.bdd.utils.IConstant.*;

import java.time.Duration;

import amfam.bdd.objects.AddressPage;
import amfam.bdd.objects.GetAQuotePage;
import amfam.bdd.objects.LandingPage;
import amfam.bdd.utils.Constant;
import amfam.bdd.utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	
	public static WebDriver driver;
	public static LandingPage landingPage;
	public static GetAQuotePage getAQuotePage;
	public static AddressPage addressPage;
	ReadProperties envVar = new ReadProperties();
	
	public void setUpDriver(String browserName) {
		String url = envVar.getProperty(URL);
		long pageLoadWait = envVar.getNumProperty(PAGELOAD_WAIT);
		long implicitWait = envVar.getNumProperty(IMPLECIT_WAIT);
		
		initDriver(browserName);
		initClasses(driver);
		driver.get(url);
		driver.manage().window().maximize()	;
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	}
	
	public void initClasses(WebDriver driver) {
		landingPage = new LandingPage(driver);
		getAQuotePage = new GetAQuotePage(driver);
		addressPage = new AddressPage(driver);
	}
	
	public void initDriver(String driverName) {
		switch (driverName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
	}
	
	public void tearUp() {
		driver.quit();
	}
	
	@SuppressWarnings("unused")
	private String getString(Constant constant) {
		return constant.name();
	}
}
