package EcommerceE2Eautomation;

import EcommerceE2Eautomation.pageobjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CompleteOrderTest {

    public static void main(String[] args) throws InterruptedException {

        String productName = "adidas original";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.manage().window().maximize();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        ProductCatalogue orderProduct = landingPage.loginApplication(
                    "hautomation@email.com", "P@s$w0rd!");//optimise creating new object as new ProductCa...

        //ProductCatalogue orderProduct = new ProductCatalogue(driver);
        List<WebElement> listOfProducts = orderProduct.getProductList();
        //orderProduct.getProductName(productName);
        orderProduct.addProductToCart(productName);

        CartPage cartPage = orderProduct.goToCart(); //encapsulation of Cartpage object
        boolean match = cartPage.verifyProductTitle(productName);
        Assert.assertTrue(match); //test case validation (assert) should be kept in test case file

        CheckoutPage checkoutPage = cartPage.goToCheckOut();
        checkoutPage.selectCountry("ind");

        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();

    }
}
