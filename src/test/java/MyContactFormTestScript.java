import PageObject.FeaturesPage;
import PageObject.HomePage;
import PageObject.SampleFormPage;
import ReusableFiles.TestUtil;
import Utilities.ExtentManager;
import Verification.VerifyPage;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import static Base.BaseClass.*;

public class MyContactFormTestScript {
	SampleFormPage sampleFormPage;
	FeaturesPage featuresPage;

	@BeforeSuite
	public void beforeSuite() {
		ExtentManager.setExtent();
	}

	@BeforeTest
	public void setDriver() {
		loadConfig();
		PropertyConfigurator.configure(properties.getProperty("filePath"));
		LaunchApp(properties.getProperty("Url"));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void sampleFormPageTest(String subject, String email, String text, String multipleText, String option,
			String visibleText, String Countries, String Canadian, String Prefix, String firstname, String lastname,
			String Day, String Month, String Year) {
		if (VerifyPage.verifyPageTitle(properties.getProperty("Exp_Title"))) {
			sampleFormPage = new SampleFormPage();
			HomePage homePage = new HomePage();
			homePage.enterSearchProduct();
			sampleFormPage.setSamplePage(subject, email, text, multipleText, option, visibleText, Countries, Canadian,
					Prefix, firstname, lastname, Day, Month, Year);

		}
	}

	/*
	 * @Test public void FeaturesPageTest() throws IOException { featuresPage = new
	 * FeaturesPage(); featuresPage.txtWriter(); }
	 */

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}