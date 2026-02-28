package test;

import base.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

public class BaseTest {

    @BeforeClass
    public void openBrowser(@Optional("chrome") String browserName,
                            @Optional("https://www.google.com") String baseURL){
        DriverManager.getBrowserInstance().initializeSession(browserName, baseURL);
    }

    @AfterClass
    public void closeBrowser(){
        DriverManager.getBrowserInstance().closeSession();
    }
}
