package EcommerceE2Eautomation.pageobjects;

import EcommerceE2Eautomation.abstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        //initialization code
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //WebElement userEmail = driver.findElement(By.id("userEmail"));
    //PageFactory
    @FindBy(id="userEmail") WebElement userEmail;
    @FindBy(id="userPassword") WebElement passWord;
    @FindBy(id="login") WebElement submit;

    public ProductCatalogue loginApplication(String email, String myPassword) //login action method
    {
        userEmail.sendKeys(email);
        passWord.sendKeys(myPassword);
        submit.click();
        ProductCatalogue orderProduct = new ProductCatalogue(driver);
        return orderProduct;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }

}
