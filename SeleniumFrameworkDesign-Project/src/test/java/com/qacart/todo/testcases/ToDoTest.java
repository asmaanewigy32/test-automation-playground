package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class ToDoTest extends BaseTest {


    @Test
    public void shouldBeAbleToAddNewToDo()
    {
        LoginPage loginPage = new LoginPage(driver);
        String actualResult=
                loginPage
                        .load()
                        .login("asmaa@example.com","Qa-123456")
                        .clickOnPlusButton()
                        .addNewTask("Learn Selenium")
                        .getTodoText();
        Assert.assertEquals("Learn Selenium",actualResult);
    }

    @Test
    public void shouldBeAbleToDeleteToDo()
    {
        LoginPage loginPage = new LoginPage(driver);
        boolean isNoToDoMassageIsDisplayed=
                loginPage
                        .load()
                        .login("asmaa@example.com","Qa-123456")
                        .clickOnPlusButton()
                        .addNewTask("Learn Selenium")
                        .clickOnDeleteButton()
                        .isNoTodoMassageDisplayed();

        Assert.assertTrue(isNoToDoMassageIsDisplayed);

    }
}
