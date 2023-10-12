package PageObject.Amazon;
/*
user:
Description:
*/

import Utilities.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Base.BaseClass.driver;

public class AmazonProductPage {
    public static final String ANSI_RESET="\u001B[0m";

    public static final String ANSI_RED="\u001B[31m";

    @FindBy(xpath="//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/child::span")
    List<WebElement> productName;

    public AmazonProductPage(){
        PageFactory.initElements(driver,this);
    }

    public void setProductPage(String searchProduct){

        for (int product = 0; product < productName.size(); product++) {
            String productList = productName.get(product).getText();

            if ((productList.toLowerCase().contains(searchProduct.toLowerCase()))) {

                Log.info(searchProduct + " is displayed on Product Title: " + productList);

            } else if (!(productList.toLowerCase().contains(searchProduct.toLowerCase()))) {
                Log.info(ANSI_RED+searchProduct + " is not displayedProduct Title: " + productList+ANSI_RESET);

            }
        }
    }
    }