package mobileApUi;

import base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class CheckTest extends BaseTest {

    @Test
    public void firstTest(){
       WebDriver driver = DriverManager.getBrowserInstance().getDriver();
        System.out.println("Browser title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google...", "Title does not matches!!");
    }
}
