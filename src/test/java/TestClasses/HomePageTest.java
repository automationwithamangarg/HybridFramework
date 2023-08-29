package TestClasses;

import Base.BaseClass;
import PageClasses.HomePage;
import PageClasses.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

public class HomePageTest extends BaseClass {
    private static final Logger log = LogManager.getLogger(HomePageTest.class);
    LoginPage loginPage;
    HomePage homePage;
    public HomePageTest(){
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
        loginPage.Login(properties.getProperty("username"),properties.getProperty("password"));
        homePage = new HomePage();
    }

    @Test (groups = {"Test 1"})
    public void clickContact_icon(){
       homePage.clickContacts();
    }
}
