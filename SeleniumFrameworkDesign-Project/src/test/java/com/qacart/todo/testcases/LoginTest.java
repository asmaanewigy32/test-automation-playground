package com.qacart.todo.testcases;

import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword()
    {
        WebDriver driver = new DriverFactory().initializeDriver();
        driver.get("https://qacart-todo.herokuapp.com");

        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("asmaa@example.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("Qa-123456");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();

        boolean isWelcomeDisplayed= driver.findElement(By.cssSelector("[data-testid=\"welcome\"]")).isDisplayed();

        Assert.assertTrue(isWelcomeDisplayed);
        driver.quit();

    }
}
