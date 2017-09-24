package Section_14;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//lecture 109
public class L109_FindWindowSize {
    private WebDriver driver;
    private String baseUrl = "http://letskodeit.teachable.com/p/practice";
    private JavascriptExecutor js;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        driver = new ChromeDriver();
        //casting driver into javascriptExecutor
        js=(JavascriptExecutor)driver;
//        driver.manage().window().maximize();

    }
    @Test
    public void test() throws InterruptedException {
        //navigation
        js.executeScript("window.location = 'http://letskodeit.teachable.com/p/practice';");

        //size of window
        // we casting as a long because in java script it return a long
        long height = (Long)js.executeScript("return window.innerHeight;");
        long width =  (Long)js.executeScript("return window.innerWidth;");

        System.out.println("height is : "+height);
        System.out.println("width is : "+width);

    }

    @AfterTest
    public void tearDown() throws InterruptedException{
        //        driver.close();
        Thread.sleep(2000);
        driver.close();
    }
}
