package EcommerceE2Eautomation.abstractComponents;

import EcommerceE2Eautomation.pageobjects.CartPage;
import EcommerceE2Eautomation.pageobjects.CheckoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AbstractComponents {

    WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="[routerlink*='cart']")
    WebElement viewCart;

    @FindBy(css=".totalRow button")
    WebElement checkout;

    public void waitForElementToAppear(By findEleBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findEleBy)); //By locator (not WebElement)
    }

    public CartPage goToCart()
    {
        viewCart.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public CheckoutPage goToCheckOut()
    {
        checkout.click();
        return new CheckoutPage(driver);
    }

    public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
        Thread.sleep(1000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.invisibilityOf(ele)); //By locator (not WebElement)
    }


}
