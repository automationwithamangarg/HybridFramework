package TestClasses;

import Base.BaseClass;
import PageClasses.ContactPage;
import PageClasses.HomePage;
import PageClasses.LoginPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContactPageTest extends BaseClass {
    private static final Logger log = LogManager.getLogger(BaseClass.class);
    LoginPage loginPage;
    HomePage homePage;
    ContactPage contactPage;
    public ContactPageTest(){
        super();
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After test class method");
    }

    @BeforeMethod
    public void initializeLoginPage(ITestContext context){
        System.out.println("Before method steps");
        //Calling methods from baseclass
       // initialization();
        extentTest = extentReports.createTest(context.getName());
        log.info("User initialized and is on LoginPage");
        extentTest.info("User initialized and is on LoginPage");
        //Creating the loginPage object
    }

    @BeforeTest
    public void init(){
        System.out.println("Before test method");
        initialization();
        loginPage = new LoginPage();
        loginPage.Login(properties.getProperty("username"),properties.getProperty("password"));
        homePage = new HomePage();
        homePage.clickContacts();
        contactPage = new ContactPage();

    }
    @Test(priority = 0,enabled = true, groups = {"Test 1"})
    public void verifyContactIcon(){
        String actual = contactPage.verifyUserIsOnContactPage();
        String expected = "Contacts";
        Assert.assertEquals(actual,expected);
        log.info("Verifying user is on contact page");
        extentTest.info("Verifying user is on contact page");
    }

    @DataProvider(name = "read_test_data")
    public Object[][] read_test_data(){
        Object[][] data = getTestData("Sheet1");
        return data;
    }

    @Test(priority = 1,dependsOnMethods = "verifyContactIcon", dataProvider = "read_test_data")
    public void createContact(String firstName1, String lastName1, String email1){
        contactPage.clickCreateBtn();
        contactPage.createNewContact(firstName1,lastName1,email1);
    }

    @AfterTest
    public void tearDown(){
        System.out.println("Test AfterTest Steps");
        driver.close();
    }
}
