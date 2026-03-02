package mobileApUi;

import base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MobileApUiPage;
import util.Utils;

import static util.Utils.actionClick;
import static util.Utils.handleDropDown;

public class MobilApUiTest extends BaseTest {
    /**
     * @implNote Getting Page objects for MoMobileApUiPage
     */
    MobileApUiPage mobileApUiPage = new MobileApUiPage(DriverManager.getBrowserInstance().getDriver());

    /**
     * @implNote Getting first-test action
     */
    @Test
    public void firstTest(){
        WebDriver driver = DriverManager.getBrowserInstance().getDriver();
        System.out.println("Browser title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google", "Title does not matches!!");
    }

    /**
     * @implNote Getting second-test action
     */
    @Test
    public void secondTest(){
        WebDriver driver = DriverManager.getBrowserInstance().getDriver();
        System.out.println("Browser title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google", "Title does not matches!!");
    }

    /**
     * @implNote Getting third-test action
     */
    @Test
    public void thirdTest(){
        WebDriver driver = DriverManager.getBrowserInstance().getDriver();
        System.out.println("Browser title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google", "Title does not matches!!");
    }

    /**
     * @implNote Getting fourth-test action
     */
    @Test
    public void fourthTest(){
        WebDriver driver = DriverManager.getBrowserInstance().getDriver();
        System.out.println("Browser title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google", "Title does not matches!!");
        handleDropDown(mobileApUiPage.getSearchField(), Utils.SelectType.INDEX, 2);
        actionClick(mobileApUiPage.getSearchField());
    }
}
