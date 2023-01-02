package EcommerceE2Eautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("hautomation@email.com");
        driver.findElement(By.id("userPassword")).sendKeys("P@s$w0rd!");
        driver.findElement(By.id("login")).click();

        //Test case: Add Adidas Original and iPhone 13 Pro products to cart
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

        //Search, filter and find our product
        WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b"))
                .getText().equalsIgnoreCase("adidas original")).findFirst().orElse(null);
        //Select and add it to cart
        //Because we are already in our product scope(prod.) we can then find Add To Cart button for product and click on it
        //System.out.println("driver=" + driver); //code to confirm the driver variable
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();


    }
}
