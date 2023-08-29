package StepDefinitions;

import Base.BaseClass;
import PageClasses.HomePage;
import PageClasses.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class HomePageSteps extends BaseClass {

    private static Logger log = LogManager.getLogger(HomePageSteps.class);

    public LoginPage loginPage;
    public HomePage homePage;

    public HomePageSteps(){
        super();
    }
    @Then("User verify {string} on HomePage")
    public void user_verify_on_home_page(String string) {
        homePage = new HomePage();
        homePage.verifyUserName(string);
     }


    @Given("User is on step1")
    public void user_is_on_step1() {
    System.out.println("Test Step 1");
    }
    @When("User is on Step2")
    public void user_is_on_step2() {
        System.out.println("Test Step 2");

    }
    @And("User verify Step3")
    public void user_verify_step3() {
        System.out.println("Test Step 3");
    }



}
