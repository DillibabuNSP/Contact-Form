package ActionDriver;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static Base.BaseClass.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class Action {
    static Logger log= Logger.getLogger(Action.class);

    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }

    public static void waitForElementIsCilckable(WebDriver driver,WebElement ele){
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    try{
        wait.until(elementToBeClickable(ele));
        log.info("Element is Cilckable");
    } catch(Exception exception){
        log.info("Element is not Cilckable");
        exception.printStackTrace();
    }
    }

    public static void waitForElementIsVisible(WebDriver driver,WebElement ele){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        try{
            wait.until(visibilityOf(ele));
            log.info("Element is Visible");
        } catch(Exception exception){
            log.info("Element is not Visible");
            exception.printStackTrace();
        }
    }

    public static void click(WebDriver driver, WebElement ele) {
        if(isElementPresent(driver,ele)){
        Actions act = new Actions(driver);
        act.moveToElement(ele).click().build().perform();
        }
    }


    public static boolean isElementPresent(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();
            flag = true;
        } catch (Exception e) {
            //log.info();("Location not found: "+locatorName);
            flag = false;
        } finally {
            if (flag) {
                log.info("Successfully Found element at");

            } else {
                log.info("Unable to locate element at");
            }
        }
        return flag;
    }


    public static boolean isDisplayed(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = isElementPresent(driver, ele);
        if (flag) {
            flag = ele.isDisplayed();
            if (flag) {
                log.info("The element is Displayed");
            } else {
                log.info("The element is not Displayed");
            }
        } else {
            log.info("Not displayed ");
        }
        return flag;
    }


    public boolean isSelected(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = isElementPresent(driver, ele);
        if (flag) {
            flag = ele.isSelected();
            if (flag) {
                log.info("The element is Selected");
            } else {
                log.info("The element is not Selected");
            }
        } else {
            log.info("Not selected ");
        }
        return flag;
    }


    public boolean isEnabled(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = isElementPresent(driver, ele);
        if (flag) {
            flag = ele.isEnabled();
            if (flag) {
                log.info("The element is Enabled");
            } else {
                log.info("The element is not Enabled");
            }
        } else {
            log.info("Not Enabled ");
        }
        return flag;
    }

    /**
     * Type text at location
     *
     * @param
     * @param text
     * @return - true/false
     */

    public static boolean enterTextValue(WebElement ele, String text) {
        boolean flag = false;
        try {
            flag = ele.isDisplayed();
            ele.clear();
            ele.sendKeys(text);
             //logger.info("Entered text :"+text);
            flag = true;
        } catch (Exception e) {
            log.info("Location Not found");
            flag = false;
        } finally {
            if (flag) {
                log.info("Successfully entered value");
            } else {
                log.info("Unable to enter value");
            }

        }
        return flag;
    }


    public boolean selectBySendkeys(String value,WebElement ele) {
        boolean flag = false;
        try {
            ele.sendKeys(value);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Select value from the DropDown");
            } else {
                log.info("Not Selected value from the DropDown");
                // throw new ElementNotFoundException("", "", "")
            }
        }
    }

    public static boolean getText(WebDriver driver, WebElement element) {
        boolean flag = false;
        flag = isElementPresent(driver, element);
        if (flag) {
            element.getText();
            flag=true;
            if (flag) {
                log.info("The text is gathered");
            } else {
                log.info("The text can't be obtained");
            }
        } else {
            log.info("Not Obtained ");
        }
        return flag;
    }
    /**
     * select value from DropDown by using selectByIndex
     *
     * @param      : Action to be performed on element (Get it from Object
     *                    repository)
     *
     * @param index       : Index of value wish to select from dropdown list.
     *
     * @param  : Meaningful name to the element (Ex:Year Dropdown, items
     *                    Listbox etc..)
     *
     */

    public static boolean selectByIndex(WebElement element, int index) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByIndex(index);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                log.info("Option selected by Index");
            } else {
                log.info("Option not selected by Index");
            }
        }
    }

    /**
     * select value from DD by using value
     *
     * @param      : Action to be performed on element (Get it from Object
     *                    repository)
     *
     * @param value       : Value wish to select from dropdown list.
     *
     * @param  : Meaningful name to the element (Ex:Year Dropdown, items
     *                    Listbox etc..)
     */


    public boolean selectByValue(WebElement element,String value) {
        boolean flag = false;
        try {
            Select s = new Select(element);
            s.selectByValue(value);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Option selected by Value");
            } else {
                log.info("Option not selected by Value");
            }
        }
    }

    /**
     * select value from DropDown by using selectByVisibleText
     *
     * @param      : Action to be performed on element (Get it from Object
     *                    repository)
     *
     * @param visibleText : VisibleText wish to select from dropdown list.
     *
     * @param  : Meaningful name to the element (Ex:Year Dropdown, items
     *                    Listbox etc..)
     */


    public static boolean selectByVisibleText(String visibleText, WebElement ele) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(visibleText);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                log.info("Option selected by VisibleText");
            } else {
                log.info("Option not selected by VisibleText");
            }
        }
    }


    public boolean mouseHoverByJavaScript(WebElement ele) {
        boolean flag = false;
        try {
            WebElement mo = ele;
            String javaScript = "var evObj = document.createEvent('MouseEvents');"
                    + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                    + "arguments[0].dispatchEvent(evObj);";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(javaScript, mo);
            flag = true;
            return true;
        }

        catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("DemoQA.MouseOver Action is performed");
            } else {
                log.info("DemoQA.MouseOver Action is not performed");
            }
        }
    }


    public static boolean JSClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
            // driver.executeAsyncScript("arguments[0].click();", element);

            flag = true;

        }

        catch (Exception e) {
            throw e;

        } finally {
            if (flag) {
                log.info("Click Action is performed");
            } else if (!flag) {
                log.info("Click Action is not performed");
            }
        }
        return flag;
    }


    public boolean switchToFrameByIndex(WebDriver driver,int index) {
        boolean flag = false;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(visibilityOfElementLocated(By.xpath("//iframe")));
            driver.switchTo().frame(index);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Frame with index \"" + index + "\" is selected");
            } else {
                log.info("Frame with index \"" + index + "\" is not selected");
            }
        }
    }

    /**
     * This method switch the to frame using frame ID.
     *
     * @param idValue : Frame ID wish to switch
     *
     */

    public boolean switchToFrameById(WebDriver driver,String idValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(idValue);
            flag = true;
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                log.info("Frame with Id \"" + idValue + "\" is selected");
            } else {
                log.info("Frame with Id \"" + idValue + "\" is not selected");
            }
        }
    }

    /**
     * This method switch the to frame using frame Name.
     *
     * @param nameValue : Frame Name wish to switch
     *
     */

    public boolean switchToFrameByName(WebDriver driver,String nameValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(nameValue);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Frame with Name \"" + nameValue + "\" is selected");
            } else if (!flag) {
                log.info("Frame with Name \"" + nameValue + "\" is not selected");
            }
        }
    }


    public boolean switchToDefaultFrame(WebDriver driver) {
        boolean flag = false;
        try {
            driver.switchTo().defaultContent();
            flag = true;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                // SuccessReport("SelectFrame ","Frame with Name is selected");
            } else if (!flag) {
                // failureReport("SelectFrame ","The Frame is not selected");
            }
        }
    }


    public void mouseOverElement(WebDriver driver,WebElement element) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(element).build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                log.info(" MouserOver Action is performed on ");
            } else {
                log.info("DemoQA.MouseOver action is not performed on");
            }
        }
    }


    public boolean moveToElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", ele);
            Actions actions = new Actions(driver);
            // actions.moveToElement(driver.findElement(locator)).build().perform();
            actions.moveToElement(ele).build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    public boolean mouseover(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(ele).build().perform();
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            /*
             * if (flag) {
             * SuccessReport("DemoQA.MouseOver ","MouserOver Action is performed on \""+locatorName
             * +"\""); } else {
             * failureReport("DemoQA.MouseOver","DemoQA.MouseOver action is not performed on \""
             * +locatorName+"\""); }
             */
        }
    }

    public boolean draggable(WebDriver driver,WebElement source, int x, int y) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDropBy(source, x, y).build().perform();
            Thread.sleep(5000);
            flag = true;
            return true;

        } catch (Exception e) {

            return false;

        } finally {
            if (flag) {
                log.info("Draggable Action is performed on \""+source+"\"");
            } else if(!flag) {
                log.info("Draggable action is not performed on \""+source+"\"");
            }
        }
    }

    public boolean draganddrop(WebDriver driver,WebElement source, WebElement target) {
        boolean flag = false;
        try {
            new Actions(driver).dragAndDrop(source, target).perform();
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("DragAndDrop Action is performed");
            } else if(!flag) {
                log.info("DragAndDrop Action is not performed");
            }
        }
    }


    public boolean slider(WebDriver driver,WebElement ele, int x, int y) {
        boolean flag = false;
        try {
            // new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
            // .perform();
            new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
            Thread.sleep(5000);
            flag = true;
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("Slider Action is performed");
            } else {
                log.info("Slider Action is not performed");
            }
        }
    }


    public boolean rightclick(WebDriver driver,WebElement ele) {
        boolean flag = false;
        try {
            Actions clicker = new Actions(driver);
            clicker.contextClick(ele).perform();
            flag = true;
            return true;
            // driver.findElement(by1).sendKeys(Keys.DOWN);
        } catch (Exception e) {

            return false;
        } finally {
            if (flag) {
                log.info("RightClick Action is performed");
            } else {
                log.info("RightClick Action is not performed");
            }
        }
    }


    public boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
        boolean flag = false;
        try {
            Set<String> windowList = driver.getWindowHandles();

            String[] array = windowList.toArray(new String[0]);

            driver.switchTo().window(array[count-1]);

            if (driver.getTitle().contains(windowTitle)){
                flag = true;
            }else{
                flag = false;
            }
            return flag;
        } catch (Exception e) {
            //flag = true;
            return false;
        } finally {
            if (flag) {
                log.info("Navigated to the window with title");
            } else {
                log.info("The Window with title is not Selected");
            }
        }
    }

    public boolean switchToNewWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s=driver.getWindowHandles();
            Object popup[]=s.toArray();
            driver.switchTo().window(popup[1].toString());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        } finally {
            if (flag) {
                log.info("Window is Navigated with title");
            } else {
                log.info("The Window with title: is not Selected");
            }
        }
    }

    public boolean switchToOldWindow(WebDriver driver) {
        boolean flag = false;
        try {

            Set<String> s=driver.getWindowHandles();
            Object popup[]=s.toArray();
            driver.switchTo().window(popup[0].toString());
            flag = true;
            return flag;
        } catch (Exception e) {
            flag = false;
            return flag;
        } finally {
            if (flag) {
                log.info("Focus navigated to the window with title");
            } else {
                log.info("The Window with title: is not Selected");
            }
        }
    }

    public int getColumncount(WebElement row) {
        List<WebElement> columns = row.findElements(By.tagName("td"));
        int a = columns.size();
        log.info(columns.size());
        for (WebElement column : columns) {
            System.out.print(column.getText());
            System.out.print("|");
        }
        return a;
    }


    public int getRowCount(WebElement table) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int a = rows.size() - 1;
        return a;
    }


    /**
     * Verify alert present or not
     *
     * @return: Boolean (True: If alert preset, False: If no alert)
     *
     */

    public boolean Alert(WebDriver driver) {
        boolean presentFlag = false;
        Alert alert = null;

        try {
            // Check the presence of alert
            alert = driver.switchTo().alert();
            // if present consume the alert
            alert.accept();
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            // Alert present; set the flag

            // Alert not present
            ex.printStackTrace();
        } finally {
            if (!presentFlag) {
                log.info("The Alert is handled successfully");
            } else{
                log.info("There was no alert to handle");
            }
        }

        return presentFlag;
    }

    public static boolean launchUrl(WebDriver driver, String url) {
        boolean flag = false;
        try {
            driver.navigate().to(url);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                log.info("Successfully launched \""+url+"\"");
            } else {
                log.info("Failed to launch \""+url+"\"");
            }
        }
    }


    public boolean isAlertPresent(WebDriver driver)
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }


    public static String getPageTitle(WebDriver driver) {
        boolean flag = false;

        String text = driver.getTitle();
        if (flag) {
            log.info("Title of the page is: \""+text+"\"");
        }
        return text;
    }


    public String getCurrentURL(WebDriver driver)  {
        boolean flag = false;

        String text = driver.getCurrentUrl();
        if (flag) {
            log.info("Current URL is: \""+text+"\"");
        }
        return text;
    }

    public static boolean checkboxClick(WebDriver driver,List<WebElement> locator) {
        boolean flag = false;
        try {
            for(int box=0;box<locator.size();box++){
                locator.get(box).click();
            }
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                log.info("Able to click on CheckBox");
            } else {
                log.info("Click Unable to click on CheckBox");
            }
        }
    }


    public static boolean elementToClick(WebElement locator, String locatorName) {
        boolean flag = false;
        try {
            locator.click();
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                log.info("Able to click on \""+locatorName+"\"");
            } else {
                log.info("Click Unable to click on \""+locatorName+"\"");
            }
        }

    }


    public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(visibilityOf(element));
            element.click();
        }catch(Exception e) {
        }
    }

    public static void implicitWait( int timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
    }

    public void explicitWait(WebElement element, int timeOut ) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        wait.until(visibilityOf(element));
    }

    public static void pageLoadTimeOut( int timeOut) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
    }

    public static String screenShot(WebDriver driver, String filename) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") +File.separator+"ScreenShots"+File.separator + filename + "_" + dateName + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }

        String newImageString = "G:"+File.separator+"myContactForm"+File.separator+"Reports" + filename + "_"
                + dateName + ".png";
        return newImageString;
    }

    public static String getCurrentTime() {
        String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
        return currentDate;
    }

    public static String[] getMonthYear(String monthYearVal){
        return monthYearVal.split("");
    }

    public void selectDate(WebElement locator, String calenderHeader,String Exp_day,String Exp_Month,String Exp_Year,WebElement navigation) throws InterruptedException {
        if(isElementPresent(driver,locator)){
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOfAllElementsLocatedBy(By.xpath(calenderHeader)));
            if(Exp_Month.equals("Feb")&& Integer.parseInt(Exp_day)>29){
                System.out.println("Wrong Date:"+Exp_Month+":"+Exp_day);
                return;
            }
            if(Integer.parseInt(Exp_day)>31){
                System.out.println("Wrong Date:"+Exp_Month+":"+Exp_day);
                return;
            }

            String monthYearVal=locator.getText();
            while (!(getMonthYear(monthYearVal)[0].equals(Exp_Month))&& getMonthYear(monthYearVal)[1].equals(Exp_Year)){

                navigation.click();
            }
            try{
                driver.findElement(By.xpath("//a[text()='"+Exp_day+"']")).click();
                Thread.sleep(5000);
            }catch(Exception exception){
                System.out.println("Wrong date: "+Exp_Month+":"+Exp_day);

            }
        }
    }

    public static void time(int value){
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate now=LocalDate.now();
        LocalDate returnValue=now.minusDays(value);
        LocalDate plusTime=now.plusDays(value);
        System.out.println(dtf.format(returnValue)+"//"+dtf.format(plusTime));
    }

    public static void find(LocalDate  first_date, LocalDate second_date)
    {
        // Get period between the first and the second date
        Period difference = Period.between(first_date, second_date);
        // Show date difference in years, months, and days
        System.out.print("Difference between two dates is:\n");
        System.out.printf( "%d days, %d months and %d years", difference.getDays(), difference.getMonths(),
                difference.getYears());
        Action.time(20);

/*
        // Create first and second date using LocalDate's of() method
        LocalDate first_date = LocalDate.of(2022, 03, 15);
        LocalDate second_date = LocalDate.of(2022, 03, 22);
        // Calling find() method to get and print the period between both dates
        Action.find(first_date, second_date);
        Date d1 = (new GregorianCalendar(2022, Calendar.MARCH, 18)).getTime();
//creating a constructor of the Date class
        Date d2 = new Date();
//calling the method and prints the day name
        log.info("This date was on: " + dayName(d1));
*/

    }

    public static String dayName(Date d){
//EEEE represents full day name
        DateFormat f = new SimpleDateFormat("EEEE");
        try
        {
            return f.format(d);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
    
    /**
     * An expectation for checking that an element is either invisible or not
     * present on the DOM.
     *
     * @param locator used to find the element
     */
    public static ExpectedCondition<Boolean> invisibilityOfElementLocated(final By locator) {
      return new ExpectedCondition<Boolean>() {
        @Override
        public Boolean apply(WebDriver driver) {
          try {
            return !(driver.findElement(locator).isDisplayed());
          } catch (NoSuchElementException e) {
            // Returns true because the element is not present in DOM. The
            // try block checks if the element is present but is invisible.
            return true;
          } catch (StaleElementReferenceException e) {
            // Returns true because stale element reference implies that element
            // is no longer visible.
            return true;
        }
      }
      };      
   }

}
      