package EcommerceE2Eautomation.pageobjects;

import EcommerceE2Eautomation.abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;

    public CartPage(WebDriver driver)
    {
        //initialization code
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".cartSection h3")
    List<WebElement> productTitle;


    public boolean verifyProductTitle(String productName)
    {
        boolean match = productTitle.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }








}
