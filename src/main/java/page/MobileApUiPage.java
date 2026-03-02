package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileApUiPage {

    /**
     * @implNote Used PageFactory class to get volatile WebElement
     * @param driver
     */
    public MobileApUiPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /**
     * @implNote X-paths
     */
    @FindBy(name = "q")
    private WebElement searchField;

    /**
     * @implNote Getter methods to get private member visibility
     */
    public WebElement getSearchField(){
        return searchField;
    }

    /**
     * @implNote Business logics
     */
    public void enterTextToSearchField(){
        getSearchField().sendKeys("Hello");
    }
}
