package PageClasses;

import Base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BaseClass {

    //Logger class we're defining as private to use withing this class only
    private static final Logger log = LogManager.getLogger(LoginPage.class);


    //Creating pageFactory using PageFactory class, Telling the driver to work on this page
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    By userName_field = By.name("email");
    By password_field = By.name("password");
    By Login_btn = By.xpath("//div[text()='Login']");

    By Error_msg = By.xpath("//div[@class='ui negative message']//child::div");

    //Created method to login on LoginPage
    public HomePage Login(String username,String password){
        //Used explicitWait and referring to the method
        setExplicitWait(20);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(userName_field))
                .clear();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(userName_field))
                .sendKeys(username);
        log.info("Entering username :"+properties.getProperty("username"));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(password_field))
                .clear();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(password_field))
                .sendKeys(password);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(Login_btn)).click();
        log.info("User able to login and user is on Homepage");
        return new HomePage();
    }


    public String getErrorMessage(){
         String errorMessage = driver.findElement(Error_msg).getText();
         return errorMessage;
    }

}
