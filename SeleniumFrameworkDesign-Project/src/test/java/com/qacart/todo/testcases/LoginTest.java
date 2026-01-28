package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.ToDoPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        loginPage.login("asmaa@example.com","Qa-123456");

        ToDoPage toDoPage = new ToDoPage(driver);
        boolean isWelcomeDisplayed= toDoPage.isWelcomeMassageDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);

    }
}
