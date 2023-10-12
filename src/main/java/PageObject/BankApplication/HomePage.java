package PageObject.BankApplication;/*
user:
Description:
*/

import ActionDriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Base.BaseClass.driver;

public class HomePage {

@FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;

public HomePage(){
    PageFactory.initElements(driver,this);
}
public void firstPage(){
    Action.click(driver,bankManagerLogin);
}
}
