package mobileApUi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class MobilApUiTest {

    @Test
    public void firstPipelineTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println("Window title is : " + title);
        driver.quit();
    }

    @Test
    public void secondPipelineTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println("Window title is : " + title);
        driver.quit();
    }

    @Test
    public void thirdPipelineTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println("Window title is : " + title);
        driver.quit();
    }
}
