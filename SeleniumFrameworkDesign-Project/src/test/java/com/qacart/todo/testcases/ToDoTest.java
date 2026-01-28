package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
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

        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.clickOnPlusButton();

        NewToDoPage newToDoPage = new NewToDoPage(driver);
        newToDoPage.addNewTodo("Learn Selenium");

        String actualResult=toDoPage.getTodoText();

        Assert.assertEquals("Learn Automation Testing",actualResult);
    }

    @Test
    public void shouldBeAbleToDeleteToDo()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        loginPage.login("asmaa@example.com","Qa-123456");

        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.clickOnPlusButton();

        NewToDoPage newToDoPage = new NewToDoPage(driver);
        newToDoPage.addNewTodo("Learn Selenium");

        toDoPage.clickOnDeleteButton();
        boolean isNoToDoMassageIsDisplayed= toDoPage.isNoTodoMassageDisplayed();
        Assert.assertTrue(isNoToDoMassageIsDisplayed);

    }
}
