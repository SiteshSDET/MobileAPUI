package util;

import base.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListenersImplement implements ITestListener {

    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        try {
            // Take screenshot
            File src = ((TakesScreenshot) DriverManager.getBrowserInstance().getDriver())
                    .getScreenshotAs(OutputType.FILE);

            // Save locally (optional)
            Files.createDirectories(Paths.get("screenshots"));
            String path = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            Files.copy(src.toPath(), Paths.get(path));
            System.out.println("Screenshot saved at: " + path);

            // Attach to Allure
            byte[] fileContent = Files.readAllBytes(src.toPath());
            Allure.addAttachment(testName + "_screenshot", new ByteArrayInputStream(fileContent));

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
