
import PageObject.BankApplication.HomePage;
import Utilities.ExtentManager;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.*;
import static Base.BaseClass.*;
import static Base.BaseClass.properties;

public class BankApplicationTestScript {
HomePage homePage;
    @BeforeSuite
    public void beforeSuite(){
        ExtentManager.setExtent();
    }

    @BeforeTest
    public void setDriver() throws InterruptedException {
        loadConfig();
        PropertyConfigurator.configure(properties.getProperty("filePath"));
        LaunchApp(properties.getProperty("Url"));
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void bankApplicationPageTest() {
        homePage=new HomePage();

        homePage.firstPage();

    }


    @AfterSuite
    public void afterSuite(){
        ExtentManager.endReport();
    }
}

