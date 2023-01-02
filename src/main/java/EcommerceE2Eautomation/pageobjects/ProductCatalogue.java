package EcommerceE2Eautomation.pageobjects;


import EcommerceE2Eautomation.abstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponents {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver)
    {
        //initialization code
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".mb-3")
    List<WebElement> products;

    By productsList = By.cssSelector(".mb-3");

    public List<WebElement> getProducts(){

        waitForElementToAppear(productsList);
        return products;
    }




}
