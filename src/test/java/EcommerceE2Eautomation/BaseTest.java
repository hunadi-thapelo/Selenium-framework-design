package EcommerceE2Eautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public void initializeDriver() throws IOException {
        Properties prop = new Properties(); //obj of Properties class

        FileInputStream fis = new FileInputStream("/Users/hunadimapulane/IdeaProjects/SeleniumFrameworkDesign/src/main/java/EcommerceE2Eautomation/resources/GlobalData.properties");
        prop.load(fis);//fileinputstream object passed to prop load method
        String browserName = prop.getProperty("browser");


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.manage().window().maximize();
    }
}
