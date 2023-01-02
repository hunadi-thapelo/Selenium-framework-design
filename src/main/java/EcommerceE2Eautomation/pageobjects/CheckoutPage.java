package EcommerceE2Eautomation.pageobjects;

import EcommerceE2Eautomation.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponents {

    WebDriver driver;

    public CheckoutPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".user__address input")
    WebElement countryInput;

    @FindBy(xpath="(//button[contains(@class,'ta-item')])[3]")
    WebElement selectCountry;

    @FindBy(css=".action__submit")
    WebElement submit;

    By countryResults = By.cssSelector(".ta-results");
    By orderConfirmMsg = By.cssSelector(".hero-primary");

    public void selectCountry(String countryName)
    {
        Actions a = new Actions(driver);
        a.sendKeys(countryInput, countryName).build().perform();
        waitForElementToAppear(countryResults);
        selectCountry.click();
    }

    public ConfirmationPage submitOrder()
    {
        submit.click(); //after order submit - we are redirected to confirmation page
        waitForElementToAppear(orderConfirmMsg);
        return new ConfirmationPage(driver);

    }

}
