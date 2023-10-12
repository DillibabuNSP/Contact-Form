import PageObject.Amazon.AmazonHomePage;
import PageObject.Amazon.AmazonProductPage;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.*;


import static Base.BaseClass.*;
import static Base.BaseClass.properties;

public class AmazonTestScript {
    AmazonHomePage  amazonHomePage;
  AmazonProductPage amazonProductPage;
    @BeforeTest
    public void setDriver() {
        loadConfig();
        BasicConfigurator.configure();
        LaunchApp(properties.getProperty("Url"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void amazonProduct(){
        amazonHomePage=new AmazonHomePage();
        amazonProductPage=new AmazonProductPage();

        amazonHomePage.enterSearchProduct(properties.getProperty("searchProduct"));
        amazonProductPage.setProductPage(properties.getProperty("searchProduct"));
    }
 }
