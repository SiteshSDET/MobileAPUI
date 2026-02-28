package util;

import base.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListenersImplement implements ITestListener {

    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        try {
            File src = ((TakesScreenshot) DriverManager.getBrowserInstance().getDriver()).getScreenshotAs(OutputType.FILE);
            String path = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(path));
            System.out.println("Screenshot saved at: " + path);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
