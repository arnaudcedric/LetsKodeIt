package section_15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//section 15 lecture 114,115
public class L_114_SwitchFrame_115 {
    private WebDriver driver;
    private String baseUrl = "http://letskodeit.teachable.com/p/practice";
    private JavascriptExecutor js;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        js = (JavascriptExecutor)driver;
    }

    @Test
    public void test() throws InterruptedException {
//        Thread.sleep(1000);
        driver.navigate().refresh();
        //switching to iframe
//        Thread.sleep(1500);
        js.executeScript("window.scroll(0, 1300);");
//        Thread.sleep(1500);
        driver.switchTo().frame("courses-iframe");
        WebElement searchBox = driver.findElement(By.id("search-courses"));
        searchBox.sendKeys("python");
        Thread.sleep(1500);
        //switch back to parent
        driver.switchTo().defaultContent();
//        Thread.sleep(1500);
//        js.executeScript("window.scroll(0, -1000);");
        driver.findElement(By.id("name")).sendKeys("Test Successful");
        Thread.sleep(1500);

    }


    @AfterTest
    public void tearDown() throws InterruptedException{
//        driver.close();
        Thread.sleep(1500);
        driver.quit();
    }

}
