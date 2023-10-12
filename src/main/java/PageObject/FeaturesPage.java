package PageObject;
/*
user:DilliBabu
Description:To verify the feature page in myContactForm
*/

import ActionDriver.Action;
import ReusableFiles.Data;
import Utilities.Log;
import Verification.VerifyPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static Base.BaseClass.driver;

public class FeaturesPage {
    @FindBy(linkText = "Features")
    WebElement features;

    @FindBy(xpath = "//div[@id='center_col']/h1")
    WebElement completeFeaturesAndBenefits;

    /*@FindBy(xpath = "//div[@id='center_col']/p[1]")
    WebElement completeText;
*/
    @FindBy(linkText="Easy to Use Form Creation Wizard")
    WebElement easyToUseFormCreationWizard;

    public FeaturesPage(){
        PageFactory.initElements(driver,this);
    }


    public void featuresPage() throws FileNotFoundException {

        /*Action.click(driver, features);*/
        String firstPath="//div[@id='center_col']/p[";
        String lastPath="]";
        for (int i = 1; i <= 2;i++) {

            List<WebElement> completeText = driver.findElements(By.xpath(firstPath+i+lastPath));
            File directoryPath = new File("D:\\myContactForm\\src\\main\\resources\\Paragraph");
            //List of all files and directories
            File filesList[] = directoryPath.listFiles();
            System.out.println("List of files and directories in the specified directory:");
            Scanner sc = null;
            for (File file : filesList) {
                System.out.println("File name: " + file.getName());
                String fileName=file.getName();
            /*System.out.println("File path: "+file.getAbsolutePath());
            System.out.println("Size :"+file.getTotalSpace());*/
                //Instantiating the Scanner class
                sc = new Scanner(file);
                String input;
                StringBuffer sb = new StringBuffer();
                while (sc.hasNextLine()) {
                    input = sc.nextLine();
                    sb.append(input + " ");
                }


                String actual = sb.toString();
                String expected = VerifyPage.readFileContents(fileName);

                Assert.assertEquals(actual, expected, "The Text contains in this paragraph is not similar");
                Log.info("The Text contains in the paragraph is Similar");
            }
        }
    }
}