package Section_14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//lecture 110
public class L110_ScrollingElementIntoView {
    private WebDriver driver;
    private String baseUrl = "http://letskodeit.teachable.com/p/practice";
    private JavascriptExecutor js;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //casting driver into javascriptExecutor
        js=(JavascriptExecutor)driver;
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        js.executeScript("window.location = 'http://letskodeit.teachable.com/p/practice';");
        Thread.sleep(3000);
        //Scroll Down
        js.executeScript("window.scroll(0, 2000);");
        Thread.sleep(2500);

        //SCroll Up
        js.executeScript("window.scroll(0, -2000);");
        Thread.sleep(2500);

        //Scroll Element Into View
        WebElement element = driver.findElement(By.id("mousehover"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2500);
        js.executeScript("window.scrollBy(0, -190)");

    }


    @AfterTest
    public void tearDown() throws InterruptedException{
        //        driver.close();
        Thread.sleep(2000);
        driver.close();
    }
}
