package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class ToDoTest extends BaseTest {


    @Test
    public void shouldBeAbleToAddNewToDo()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        ToDoPage toDoPage = loginPage.login("asmaa@example.com","Qa-123456");

        NewToDoPage newToDoPage = toDoPage.clickOnPlusButton();
        toDoPage=newToDoPage.addNewTask("Learn Selenium");

        String actualResult=toDoPage.getTodoText();
        Assert.assertEquals("Learn Automation Testing",actualResult);
    }

    @Test
    public void shouldBeAbleToDeleteToDo()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        ToDoPage toDoPage = loginPage.login("asmaa@example.com","Qa-123456");

        NewToDoPage newToDoPage = toDoPage.clickOnPlusButton();
        toDoPage = newToDoPage.addNewTask("Learn Selenium");
        toDoPage.clickOnDeleteButton();

        boolean isNoToDoMassageIsDisplayed= toDoPage.isNoTodoMassageDisplayed();
        Assert.assertTrue(isNoToDoMassageIsDisplayed);

    }
}
