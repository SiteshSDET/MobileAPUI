package util;

import base.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utils {

    public void actionClick(WebElement element){
        Actions actions = new Actions(DriverManager.getBrowserInstance().getDriver());
        actions.moveToElement(element).click().perform();
    }
}
