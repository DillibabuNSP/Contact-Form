package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ActionDriver.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Des:This class selects the browser and provides the config properties.
 * @method loadConfig()
 * @method LaunchApp()
 * */

public class BaseClass {

    public static Properties properties;
    public static WebDriver driver;


        public static void loadConfig(){

            try{
                properties =new Properties();
                System.out.println("super constructor invoked");
                String userDir=System.getProperty("user.dir");
                String pathSeparator=System.getProperty("file.separator");
                String path=userDir+pathSeparator+"src"+pathSeparator+"main"+pathSeparator+"resources"+pathSeparator+"Configuration"+pathSeparator+"MyContactForm.properties";
                properties =new Properties();
                FileInputStream fileInput=new FileInputStream(path);
                properties.load(fileInput);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void LaunchApp(String url){

            WebDriverManager.chromedriver().setup();
            String browserName= properties.getProperty("browser");

            if(browserName.equalsIgnoreCase("Chrome")){
                driver=new ChromeDriver();
            }else if(browserName.equalsIgnoreCase("FireFox")){
                driver=new FirefoxDriver();
            }else if(browserName.equalsIgnoreCase("Edge")){
                driver=new EdgeDriver();
            }

            Action.implicitWait(20);
            Action.pageLoadTimeOut(60);
            Action.launchUrl(driver,url);
            driver.manage().window().maximize();
        }
}