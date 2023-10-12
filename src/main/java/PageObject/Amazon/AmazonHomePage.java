package PageObject.Amazon;/*
user:
Description:
*/

import ActionDriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.BaseClass.driver;

public class AmazonHomePage {
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    public AmazonHomePage(){
        PageFactory.initElements(driver,this);
    }

    public void enterSearchProduct(String text){
        Action.enterTextValue(searchBox,text);
        Action.click(driver,searchButton);
    }
}
