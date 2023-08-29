package StepDefinitions;

import Base.BaseClass;
import PageClasses.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPageSteps extends BaseClass {
    private static Logger log = LogManager.getLogger(LoginPageSteps.class);
    public LoginPage loginPage;
    public LoginPageSteps(){
        super();
    }

    /*@Before
    public void initialize(){
        initialization();
        log.info("User initialized and is on LoginPage");
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }

     */
    @Given("User is on loginpage")
    public void user_is_on_loginpage() {
          //Creating the loginPage object
        loginPage = new LoginPage();
    }
    @When("User enter <username> and <password>")
    public void user_enter_username_and_password() {
        loginPage.Login(properties.getProperty("username"), properties.getProperty("password"));
        String pageTitle = getPageTitle();
    }



}
