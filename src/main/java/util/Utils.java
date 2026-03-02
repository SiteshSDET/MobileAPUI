package util;

import base.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



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
}
