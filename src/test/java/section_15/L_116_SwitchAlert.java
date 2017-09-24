package section_15;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class L_116_SwitchAlert {
    private WebDriver driver;
    private String baseUrl = "http://letskodeit.teachable.com/p/practice";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @Test
    public void test_1() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys("arnaud");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();// ok
        /*alert.getText();*/
        /*alert.dismiss()*/;//cancel

    }

    @Test
    public void test_2() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys("arnaud");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(4000);
        Alert alert = driver.switchTo().alert();
        alert.accept();// ok
        /*alert.getText();*/
        /*alert.dismiss()*/;//cancel


    }


    @AfterTest
    public void tearDown() throws InterruptedException{
        //        driver.close();
        Thread.sleep(2000);
        driver.close();
    }
}
