package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;

import java.time.Duration;

public class DriverManager {

    private static volatile DriverManager driverManager;
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * @implNote Private constructor, restrict user to create copy of object
     */
    private DriverManager(){
        if(driverManager != null){
            throw new RuntimeException("Cannot create an object for this class " + driverManager.getClass().getSimpleName());
        }
    }

    /**
     * @implNote static member to get access the browser as singleton pattern
     * @return
     */
    public static DriverManager getBrowserInstance(){
        if(driverManager == null){
            synchronized (DriverManager.class){
                if(driverManager == null){
                    driverManager = new DriverManager();
                }
            }
        }
        return driverManager;
    }

    /**
     * @implNote initializations for browser session
     * @param browserName
     * @param baseURL
     */
    public void initializeSession(String browserName, String baseURL){
        if(driver.get() == null){
            switch (browserName.toLowerCase()) {
                case "chrome":
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                case "edge":
                    driver.set(new EdgeDriver());
                    break;
                default:
                    throw new RuntimeException("Wrong browser name entered!!");
            }
        }
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get().get(baseURL);
    }

    /**
     * @implNote getting initialized driver
     * @return
     */
    public WebDriver getDriver(){
        return driver.get();
    }

    /**
     * @implNote closing browser session
     */
    public void closeSession(){
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}