package section_16_ActionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class L_119_DragAndDropActions {
    private WebDriver driver;
    private String baseUrl = "https://jqueryui.com/droppable/";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
//        actions.clickAndHold(drag).moveToElement(drop).release().perform();
        actions.dragAndDrop(drag,drop).build().perform();

    }


    @AfterTest
    public void tearDown() throws InterruptedException{
        //        driver.close();
        Thread.sleep(2000);
        driver.close();
    }
}
