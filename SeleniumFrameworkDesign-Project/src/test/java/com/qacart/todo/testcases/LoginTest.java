package com.qacart.todo.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qacart-todo.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("asmaa@example.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("Qa-123456");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();

        boolean isWelcomeDisplayed= driver.findElement(By.cssSelector("[data-testid=\"welcome\"]")).isDisplayed();

        Assert.assertTrue(isWelcomeDisplayed);
        driver.quit();

    }
}
