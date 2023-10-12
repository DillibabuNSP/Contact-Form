package PageObject;/*
user:Dillibabu
Description:To handle the Main page of the Amzon
*/

import ActionDriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static Base.BaseClass.driver;

public class HomePage {

    @FindBy(xpath = "//a[text()='Sample Forms']")
    WebElement sampleForm;


    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public void enterSearchProduct(){

        Action.click(driver,sampleForm);
    }
}