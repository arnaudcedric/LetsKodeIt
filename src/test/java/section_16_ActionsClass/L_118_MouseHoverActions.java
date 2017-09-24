package section_16_ActionsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class L_118_MouseHoverActions {
    private WebDriver driver;
    private String baseUrl = "http://letskodeit.teachable.com/p/practice";
    private JavascriptExecutor js;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void test() throws InterruptedException {
        js.executeScript("window.scrollBy(0, 1150)");
        Thread.sleep(1000);
        //finding the main element
        WebElement mainElement = driver.findElement(By.xpath("//button[text()='Mouse Hover']"));
        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        Thread.sleep(1000);
        WebElement subElement = driver.findElement(By.xpath("//a[@href='#top']"));
        action.moveToElement(subElement).click().perform();

    }

    @AfterTest
    public void tearDown() throws InterruptedException{
        //        driver.close();
        Thread.sleep(2000);
        driver.close();
    }
}
