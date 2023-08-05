package PageClasses;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.log4testng.Logger;

public class LoginPage extends BaseClass {

    //Logger class we're defining as private to use withing this class only
    private static final Logger log = Logger.getLogger(LoginPage.class);

    //Creating pageFactory using PageFactory class, Telling the driver to work on this page
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    By userName_field = By.name("email");
    By password_field = By.name("password");
    By Login_btn = By.xpath("//div[text()='Login']");

    //Created method to login on LoginPage
    public void Login(){
        //Used explicitWait and referring to the method
        setExplicitWait(20);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(userName_field))
                .sendKeys(properties.getProperty("username"));

        log.info("Entering username :"+properties.getProperty("username"));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(password_field))
                .sendKeys(properties.getProperty("password"));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(Login_btn)).click();
        log.info("User able to login and user is on Homepage");
    }


}
