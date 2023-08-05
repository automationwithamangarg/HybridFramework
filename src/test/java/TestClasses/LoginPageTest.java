package TestClasses;

import Base.BaseClass;
import PageClasses.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;
public class LoginPageTest extends BaseClass {

    private static final Logger log = Logger.getLogger(LoginPageTest.class);
    LoginPage loginPage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void initializeLoginPage(){
        //Calling methods from baseclass
        initialization();
        log.info("User initialized and is on LoginPage");
        //Creating the loginPage object
        loginPage = new LoginPage();
    }

    @Test
    public void verifyLogin(){
        //Calling the loginPage object and calling its methods
        loginPage.Login();
        String pageTitle = getPageTitle();
        Assert.assertEquals("Cogmento CRM",pageTitle);
    }

    @AfterTest
    public void tearDown() throws IOException {
        takeScreenshot(driver);
        driver.close();
        driver.quit();
    }
}
