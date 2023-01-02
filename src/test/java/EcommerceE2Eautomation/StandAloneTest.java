package EcommerceE2Eautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    public static void main(String[] args) throws InterruptedException {

        String productName = "adidas original";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("hautomation@email.com");
        driver.findElement(By.id("userPassword")).sendKeys("P@s$w0rd!");
        driver.findElement(By.id("login")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3"))); //for products to load before List

        //Test case: Add Adidas Original and iPhone 13 Pro products to cart
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        //Search, filter and find our product
        WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b"))
                .getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        //Select and add it to cart
        //Because we are already in our product scope(prod.) we can then find Add To Cart button for product and click on it
        //System.out.println("driver=" + driver); //code to confirm the driver variable
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        //Test case: Confirm product is added successfully to cart display message and
                //disappearance of loading animation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))); //improve performance

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[routerlink*='cart']")));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);

        driver.findElement(By.cssSelector(".totalRow button")).click();





    }
}
