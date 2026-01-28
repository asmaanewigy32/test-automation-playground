package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ToDoTest extends BaseTest {


    @Test
    public void shouldBeAbleToAddNewToDo()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        loginPage.login("asmaa@example.com","Qa-123456");

        driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("Learn Automation Testing");
        driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();
        String actualResult=driver.findElement(By.cssSelector("[data-testid=\"todo-text\"]")).getText();

        Assert.assertEquals("Learn Automation Testing",actualResult);
    }

    @Test
    public void shouldBeAbleToDeleteToDo()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        loginPage.login("asmaa@example.com","Qa-123456");

        driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("Learn Automation Testing");
        driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"delete\"]")).click();
        boolean isNoToDoMassageIsDisplayed=driver.findElement(By.cssSelector("[data-testid=\"no-todos\"]")).isDisplayed();
        Assert.assertTrue(isNoToDoMassageIsDisplayed);

    }
}
