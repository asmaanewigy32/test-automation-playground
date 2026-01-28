package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.ToDoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        ToDoPage toDoPage = loginPage.login("asmaa@example.com","Qa-123456");
        boolean isWelcomeDisplayed= toDoPage.isWelcomeMassageDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);

    }
}
