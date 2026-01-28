package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword()
    {
        driver.get("https://qacart-todo.herokuapp.com");

        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("asmaa@example.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("Qa-123456");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();

        boolean isWelcomeDisplayed= driver.findElement(By.cssSelector("[data-testid=\"welcome\"]")).isDisplayed();

        Assert.assertTrue(isWelcomeDisplayed);

    }
}
