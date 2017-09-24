package section_15;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;
// section 15 Lecture 113
public class L_113_SwitchWindow {
    private WebDriver driver;
    private String baseUrl = "http://letskodeit.teachable.com/p/practice";


    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException{
        setUp();

        // get the handle
        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent Handle: " + parentHandle);
        // Find Open Window button
        WebElement openWindow = driver.findElement(By.id("openwindow"));
        openWindow.click();
        Thread.sleep(1500);
        // get all handles
        Set<String> handles = driver.getWindowHandles();

        //Switching between windows
        for(String handle:handles){
            if (handle.equals(parentHandle)){
                System.out.println("Parent window: " + parentHandle);
            }else {
                System.out.println("child window: " + handle);
            }
            //below code if handle is not equal to parent switch to child window
            if (!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                Thread.sleep(1500);
                WebElement searchCourses = driver.findElement(By.id("search-courses"));
                searchCourses.sendKeys("python");
                Thread.sleep(1500);
                //driver.close closes the current focus window
                driver.close();
                break;
            }
        }
        //Switch back to the parent window
        /*
        * if you don't switch back you will have this type of exception
        * org.openqa.selenium.NoSuchWindowException: no such window: target window already          closed from unknown error: web view not found
        * you need to switch back using the below in this case
        */
        driver.switchTo().window(parentHandle);
        driver.findElement(By.id("name")).sendKeys("Test successful");
    }


    @AfterTest
    public void tearDown() throws InterruptedException{
//        driver.close();
        Thread.sleep(2000);
        driver.close();
    }
}
