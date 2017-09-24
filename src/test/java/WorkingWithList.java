import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.List;
public class WorkingWithList {
    private WebDriver driver;
    private String baseUrl="http://letskodeit.teachable.com/p/practice";
    @Test
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
        driver = new ChromeDriver();
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        System.setProperty("webdriver,gecko.driver",System.getProperty("user.dir")+"/geckodriver.exe");
//        driver = new FirefoxDriver(capabilities);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
