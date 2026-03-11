package mobileApUi;

import base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MobileApUiPage;
import util.Utils;

import static util.Utils.actionClick;
import static util.Utils.handleDropDown;
/**
 * Test class for validating Mobile App UI functionality.
 * <p>This class contains UI automation tests executed using Selenium WebDriver.
 * It extends BaseTest to reuse driver initialization and setup logic.</p>
 * @author Sitesh
 */
public class MobilApUiTest extends BaseTest {
    /**
     * Page Object instance for MobileApUiPage.
     * <p>This object is used to interact with UI elements
     * present on the Mobile App UI page.</p>
     */
    MobileApUiPage mobileApUiPage = new MobileApUiPage(DriverManager.getBrowserInstance().getDriver());

    /**
     * Test Case 1: Verify Google page title.
     * <p>Steps:
     * <ul>
     *     <li>Get WebDriver instance from DriverManager</li>
     *     <li>Fetch browser title</li>
     *     <li>Print title in console</li>
     *     <li>Validate title using TestNG assertion</li>
     * </ul>
     * Expected Result: Browser title should be "Google".
     */
    @Test
    public void firstTest(){
        WebDriver driver = DriverManager.getBrowserInstance().getDriver();
        System.out.println("Browser title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google", "Title does not matches!!");
    }

    /**
     * Test Case 2: Validate browser title again to ensure consistency.
     * <p>Steps:
     * <ul>
     *     <li>Retrieve WebDriver instance</li>
     *     <li>Fetch browser title</li>
     *     <li>Validate title with expected value</li>
     * </ul>
     * Expected Result: Title should match "Google".
     */
    @Test
    public void secondTest(){
        WebDriver driver = DriverManager.getBrowserInstance().getDriver();
        System.out.println("Browser title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google", "Title does not matches!!");
    }

    /**
     * Test Case 3: Validate browser title for third scenario.
     * <p>This test ensures that the correct page is loaded
     * and the title verification works properly.</p>
     * Expected Result: Title should be "Google".
     */
    @Test
    public void thirdTest(){
        WebDriver driver = DriverManager.getBrowserInstance().getDriver();
        System.out.println("Browser title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google", "Title does not matches!!");
    }

    /**
     * Test Case 4: Validate browser title and perform UI actions.
     * <p>Steps:
     * <ul>
     *     <li>Validate browser title</li>
     *     <li>Handle dropdown selection using INDEX</li>
     *     <li>Perform click action on search field</li>
     * </ul>
     * Methods Used:
     * <ul>
     *     <li>handleDropDown()</li>
     *     <li>actionClick()</li>
     * </ul>
     * Expected Result:
     * <ul>
     *     <li>Title validation should pass</li>
     *     <li>Dropdown option should be selected successfully</li>
     *     <li>Click action should be executed</li>
     * </ul>
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
