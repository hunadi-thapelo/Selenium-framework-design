package EcommerceE2Eautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        //initialization code
        this.driver = driver;
    }

    WebElement userEmail = driver.findElement(By.id("userEmail"));

    //PageFactory

}
