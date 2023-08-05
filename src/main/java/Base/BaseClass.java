package Base;

import PageClasses.LoginPage;
import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass extends Utils {

    //Creating object of Properties class
    public static Properties properties;

    //Created object of Loggers Class
    private static final Logger log = Logger.getLogger(BaseClass.class);

    //Baseclass is referring to Utils class using Super() keyword
    public BaseClass(){
        super();
        try{
            //Loading the properties file
            properties = new Properties();
            String filePath = currentDir+"//src/main/resources/env.properties";
            FileInputStream input = new FileInputStream(filePath);
            properties.load(input);
            log.info("Loading properties file env.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.info("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("File not found");
        }
    }

    //Initializing the driver we're using and Reading from env.properties file
    public static void initialization(){
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origin=*");
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeOut));
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
    }

}
