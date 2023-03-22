package amfam.bdd.base;

import static amfam.bdd.utils.IConstant.*;

import amfam.bdd.utils.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

	BaseClass baseClass;
	ReadProperties envVar = new ReadProperties();
	
	@Before
	public void initDriver() {
		baseClass = new BaseClass();
		baseClass.setUpDriver(envVar.getProperty(BROWSER));
	}
	
	@After
	public void exitingDriver() {
		baseClass.tearUp();
	}
}
