package PageClasses;

import Base.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class HomePage extends BaseClass {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    private static final Logger log = LogManager.getLogger(HomePage.class);

    By contacts_icon = By.xpath("//span[@class='item-text' and text()='Contacts']");
    By user_display = By.xpath("//span[class='user-display']");
    public ContactPage clickContacts(){
        Actions action = new Actions(driver);
        WebElement contacts = driver.findElement(contacts_icon);
        setExplicitWait(20);
        action.moveToElement(contacts).perform();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(contacts_icon));
        action.moveToElement(contacts).click().perform();
        log.info("Clicking on contact icon");
        return new ContactPage();
    }

    public void verifyUserName(String expectedUserName){
        String userName= driver.findElement(user_display).getText();
        Assert.assertEquals(userName,expectedUserName);
    }



}
