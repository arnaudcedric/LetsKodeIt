package Section_14;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//lecture 108,109
public class L108_JavaScriptExecutor {
    private WebDriver driver;
    private String baseUrl = "http://letskodeit.teachable.com/p/practice";
    private JavascriptExecutor js;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        driver = new ChromeDriver();
        //casting driver into javascriptExecutor
        js=(JavascriptExecutor)driver;
        driver.manage().window().maximize();

    }
    @Test
    public void test() throws InterruptedException {
        //navigation
//        driver.get(baseUrl);
        js.executeScript("window.location = 'http://letskodeit.teachable.com/p/practice';");
        //Finding element
//        driver.findElement(By.id("name")).sendKeys("python");
        WebElement testBox = (WebElement) js.executeScript("return document.getElementById('name');");
        testBox.sendKeys("test");

    }

    @AfterTest
    public void tearDown() throws InterruptedException{
        //        driver.close();
        Thread.sleep(2000);
        driver.close();
    }
}
