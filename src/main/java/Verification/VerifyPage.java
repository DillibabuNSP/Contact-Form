package Verification;


import ActionDriver.Action;
import Utilities.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static Base.BaseClass.driver;

/**
 * Des: This class verifies the page title.
 * @method verifyPageTitle()
 * */


public class VerifyPage {
    /*
     * Des: This method verifies the page title.
     * @String:expected title
     * @String:static Logger log = Logger.getLogger(VerifyPage.class);
     * */
    static Logger log = Logger.getLogger(VerifyPage.class);
    public static final String ANSI_RESET="\u001B[0m";

    public static final String ANSI_RED="\u001B[31m";

    public static Boolean verifyPageTitle(String expectedTitle) {
        boolean flag = false;
        try {
            String actual_Title = Action.getPageTitle(driver);
            Log.info(actual_Title);
            Assert.assertEquals(actual_Title,expectedTitle,"The Title are Different");
            flag = true;
            return true;

        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        } finally {
            if (flag) {
                log.info("Expected title and actual title is equal");
            } else {
                log.info("Expected title and actual title is not equal");
            }
        }
    }

    public static void verifyProduct(List<WebElement> element, String searchProductName) {
        for (int product = 0; product < element.size(); product++) {
            String productList = element.get(product).getText();

            if ((productList.toLowerCase().contains(searchProductName.toLowerCase()))) {

                log.info(searchProductName + " is displayed on Product Title: " + productList);

            } else if (!(productList.toLowerCase().contains(searchProductName.toLowerCase()))) {
                log.info(ANSI_RED+searchProductName + " is not displayedProduct Title: " + productList+ANSI_RESET);

            }
        }
    }

    public static String readFileContents(String Text) {

        //Java Logic for reading the file WebsiteContent.txt
        File f = new File("D:\\myContactForm\\src\\main\\resources\\Paragraph\\"+Text);
        FileReader fr = null;
        BufferedReader br=null;
        String text="";
        try {
            fr = new FileReader(f.getAbsolutePath());
            br = new BufferedReader(fr);
            String str="";

            while((str=br.readLine())!=null)
            {
                text = text+str;
                System.out.println("File Contents:: " + str);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return text;
    }
}