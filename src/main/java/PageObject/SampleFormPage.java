 package PageObject;/*
user:Dillibabu
Description:To handle the product searched in the Search box
*/

import ActionDriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Base.BaseClass.driver;

public class SampleFormPage {

    @FindBy(linkText = "Sample Forms")
    WebElement sampleForm;

    @FindBy(xpath = "//input[@name='email_to[]']")
    List<WebElement> sendToCheckBox;

    @FindBy(id = "subject")
    WebElement subjectBox;

    @FindBy(id = "email")
    WebElement emailBox;

    @FindBy(id = "q1")
    WebElement textBox;

    @FindBy(id="q2")
    WebElement textBoxMultiLine;

    @FindBy(id="q3")
    WebElement dropDownBox;

    @FindBy(id = "q4")
    List<WebElement> radioButton;

    @FindBy(id = "q5")
    WebElement singleCheckBox;

    @FindBy(xpath = "//input[@name='checkbox6[]']")
    List<WebElement> multipleCheckBox;

    @FindBy(id = "q7")
    WebElement dateSelector;

    @FindBy(id = "q8")
    WebElement usStates;

    @FindBy(id = "q9")
    WebElement countries;

    @FindBy(id = "q10")
    WebElement canadian;

    @FindBy(xpath = "//select[@name='q11_title']")
    WebElement prefix;

    @FindBy(xpath ="//input[@name='q11_first']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='q11_last']")
    WebElement lastName;

    @FindBy(xpath = "//select[@name='q12_month']")
    WebElement month;

    @FindBy(xpath = "//select[@name='q12_day']")
    WebElement day;

    @FindBy(xpath = "//select[@name='q12_year']")
    WebElement year;

    @FindBy(linkText = "Features")
    WebElement features;

    public SampleFormPage(){
        PageFactory.initElements(driver,this);
    }

    public void setSamplePage(String subject,String email,String text,String multipleText,
    String option,String visibleText,String Countries,String Canadian,String Prefix,
    String firstname,String lastname,String Month,String Day,String Year){

        Action.click(driver,sampleForm);
        Action.checkboxClick(driver,sendToCheckBox);
        Action.enterTextValue(subjectBox,subject);
        Action.enterTextValue(emailBox,email);
        Action.enterTextValue(textBox,text);
        Action.enterTextValue(textBoxMultiLine,multipleText);
        Action.selectByVisibleText(option,dropDownBox);
        Action.checkboxClick(driver,radioButton);
        Action.click(driver,singleCheckBox);
        Action.checkboxClick(driver,multipleCheckBox);
        /*Action.getMonthYear(dateMonthYear);*/
        Action.selectByVisibleText(visibleText,usStates);
        Action.selectByVisibleText(Countries,countries);
        Action.selectByVisibleText(Canadian,canadian);
        Action.selectByVisibleText(Prefix,prefix);
        Action.enterTextValue(firstName,firstname);
        Action.enterTextValue(lastName,lastname);
        Action.selectByVisibleText(Month,month);
        Action.selectByVisibleText(Day,day);
        Action.selectByVisibleText(Year,year);
        Action.click(driver,features);
    }
}