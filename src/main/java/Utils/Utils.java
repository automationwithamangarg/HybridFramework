package Utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class Utils {
    public static int pageLoadTimeOut= 20;
    public static int implicitWaitTime = 20;
    public static WebDriverWait explicitWait;
    //Defined our WebDriver
    public static WebDriver driver;
    //Current directory address
    public static String currentDir = System.getProperty("user.dir");

    //Constructor of Utils class calling super class
    public Utils(){
        super();
    }

    //Added screenshot method
    public static void takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        //Generating random number for screenshot name
        Random rd = new Random();
        int i = rd.nextInt();
        File destination = new File(currentDir+"//Screenshot/screenshot_"+i+".png");
        FileUtils.copyFile(file,destination);
    }

    //Getting the pageTitle of current page
    public String getPageTitle(){
        String pageTitle = driver.getTitle();
        System.out.println("Page title of current page is :"+pageTitle);
        return pageTitle;
    }

    //Adding explicit wait
    public void setExplicitWait(int seconds){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

}
