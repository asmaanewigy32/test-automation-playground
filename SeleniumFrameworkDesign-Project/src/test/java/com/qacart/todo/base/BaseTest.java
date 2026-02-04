package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookiesUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {

    protected ThreadLocal<WebDriver>  driver= new ThreadLocal<>();

    public void setDriver(WebDriver driver)
    {
        this.driver.set(driver);
    }

    public WebDriver getDriver()
    {
        return this.driver.get();
    }

    @BeforeMethod
    public void setUp()
    {
         WebDriver driver = new DriverFactory().initializeDriver();
         setDriver(driver);

    }
    @AfterMethod
    public void tearDown(ITestResult result)
    {
        // Get test method name instead of test name
        String testCaseName = result.getMethod().getMethodName();

        // Handle null or empty test case name
        if (testCaseName == null || testCaseName.isEmpty()) {
            testCaseName = "test_" + System.currentTimeMillis();
        }

        File destFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName + ".png");
        takeScreenshot(destFile);

        if (getDriver() != null) {
            getDriver().quit();
        }

    }

    public void takeScreenshot(File destFile)
    {
        try {
            File sourceFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, destFile);

            // Attach screenshot to Allure report
            try (InputStream is = new FileInputStream(destFile)) {
                Allure.addAttachment("screenshot", is);
            }
        } catch (IOException e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Step
    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies)
    {
        List<org.openqa.selenium.Cookie> seleniumCookies=CookiesUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie:seleniumCookies)
        {
            getDriver().manage().addCookie(cookie);
        }
    }
}
