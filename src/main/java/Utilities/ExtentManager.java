package Utilities;
/*
user: To perform Report Action by this class
Description:Dillibabu
*/

import ActionDriver.Action;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.IOException;

public class ExtentManager {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;


    public static void setExtent() {
        String pathSeparator=System.getProperty("file.separator");
        htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+pathSeparator+"ExtentReport"+pathSeparator+"MyReport_"+ Action.getCurrentTime() +".html");
        try {
            htmlReporter.loadXMLConfig(System.getProperty("user.dir")+pathSeparator+"src"+pathSeparator+"main"+pathSeparator+"resources"+pathSeparator+ "Configuration"+pathSeparator+"extent-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        htmlReporter.config().setDocumentTitle("MyContactForm Application");
        htmlReporter.config().setReportName("MyContactForm Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "MyContactForm Page");
        extent.setSystemInfo("Tester", "DilliBabu");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public static void endReport() {
        extent.flush();
    }
}