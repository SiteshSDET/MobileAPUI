package util;

import base.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;


public class Utils {

    /**
     * This method Use to perform click actions using Action class
     * @param element
     */
    public static void actionClick(WebElement element){
        Actions actions = new Actions(DriverManager.getBrowserInstance().getDriver());
        actions.moveToElement(element).click().perform();
    }

    /**
     * This class is used to handle drop-down type
     * @implNote enum
     */
    public enum SelectType{
        INDEX, VALUE, TEXT
    }

    /**
     * This method Use to handle drop-down dynamically for all-types
     * @param element
     * @param selectType
     * @param selectBy
     */
    public static void handleDropDown(WebElement element, SelectType selectType, Object selectBy){
        Select select = new Select(element);
        switch (selectType){
            case INDEX -> select.selectByIndex((Integer)selectBy);
            case VALUE -> select.selectByValue((String) selectBy);
            case TEXT -> select.selectByVisibleText(((String)selectBy));
        }
    }

    public static void scrollDescription(AppiumDriver driver){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))." +
                        "scrollIntoView(new UiSelector().description(\"Settings\"));"
        ));
    }

    public static void scrollHashMap(AppiumDriver driver){
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("strategy", "accessibility id");
        scrollObject.put("selector", "Settings");
        driver.executeScript("mobile: scroll", scrollObject);
    }

    public static void swipe(AppiumDriver driver, int startX, int startY, int endX, int endY, int durationMs) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX,
                        startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(durationMs),
                        PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));
    }
}
