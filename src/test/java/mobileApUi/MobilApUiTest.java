package mobileApUi;

import base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

import java.time.Duration;

public class MobilApUiTest extends BaseTest {

    @Test
    public void firstTest(){
        WebDriver driver = DriverManager.getBrowserInstance().getDriver();
        System.out.println("Browser title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google...", "Title does not matches!!");
    }
}
