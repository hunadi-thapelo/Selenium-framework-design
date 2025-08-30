package EcommerceE2Eautomation;

import EcommerceE2Eautomation.pageobjects.*;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CompleteOrderTest extends BaseTest{

    @Test
    public void completeOrder() throws InterruptedException {

        String productName = "adidas original";

        //LandingPage landingPage = launchApplication(); //changed static main method to testNG annotations
        // as method is non-static
        //removed landingpage object

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
        driver.quit();

    }
}
