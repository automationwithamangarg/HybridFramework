package TestClasses;

import Base.BaseClass;
import PageClasses.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    private static final Logger log = LogManager.getLogger(LoginPageTest.class);
    LoginPage loginPage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void initializeLoginPage(ITestContext context){
        //Calling methods from baseclass
        initialization();
        extentTest = extentReports.createTest(context.getName());
        log.info("User initialized and is on LoginPage");
        //Creating the loginPage object
        loginPage = new LoginPage();
    }

    @Test
    public void verifyLogin(){
        //Calling the loginPage object and calling its methods
        loginPage.Login(properties.getProperty("username"), properties.getProperty("password"));
        String pageTitle = getPageTitle();
        Assert.assertEquals("Cogmento CRM",pageTitle);
    }

    @Test
    public void verifyInvalidResponse(){
        loginPage.Login(properties.getProperty("username"),properties.getProperty("password"));
        String actual = loginPage.getErrorMessage();
        String expected = "Something went wrong...";
        Assert.assertEquals(actual, expected);
    }

}
