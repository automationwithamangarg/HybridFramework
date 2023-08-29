package PageClasses;

import Base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.logging.log4j.Logger;

public class ContactPage extends BaseClass {
    private static final Logger log = LogManager.getLogger(ContactPage.class);
    public ContactPage(){
        PageFactory.initElements(driver, this);
    }

    By contact_text = By.xpath("//span[@class='selectable ' and text()='Contacts']");

    By create_btn = By.xpath("//button[@class='ui linkedin button' and text()='Create']");

    By first_Name_field = By.name("first_name");
    By last_Name_field = By.name("last_name");
    By email_field = By.xpath("//input[@placeholder='Email address']");
    public String verifyUserIsOnContactPage(){
        Actions actions = new Actions(driver);
        WebElement create = driver.findElement(create_btn);
        actions.moveToElement(create).perform();
        setExplicitWait(10);
        String text=explicitWait.until(ExpectedConditions.visibilityOfElementLocated(contact_text)).getText();
        return text;
    }

    public void clickCreateBtn(){
        setExplicitWait(20);
        log.info("User clicking on create button");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(create_btn)).click();
    }

    public void createNewContact(String firstName, String lastName, String email){
        setExplicitWait(20);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(first_Name_field)).sendKeys(firstName);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(last_Name_field)).sendKeys(lastName);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(email_field)).sendKeys(email);
    }
}
