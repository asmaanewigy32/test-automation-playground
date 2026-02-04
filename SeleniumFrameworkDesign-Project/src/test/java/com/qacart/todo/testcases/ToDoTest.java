package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class ToDoTest extends BaseTest {


    @Test
    public void shouldBeAbleToAddNewToDo()
    {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        NewToDoPage newToDoPage = new NewToDoPage(driver);
        newToDoPage.load();
        //Selenium Best practices --> You should visit your webpage before and after adding the cookies
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        //Selenium Best practices --> Use maximum three UI actions in each testcase
        String actualResult = newToDoPage
                .load()
                .addNewTask("Learn Selenium")
                .getTodoText();

        Assert.assertEquals("Learn Selenium",actualResult);
    }

    @Test
    public void shouldBeAbleToDeleteToDo()
    {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());

        ToDoPage ToDoPage = new ToDoPage(driver);
        ToDoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        boolean isNoToDoMassageIsDisplayed = ToDoPage
                .load()
                .clickOnDeleteButton()
                .isNoTodoMassageDisplayed();

        Assert.assertTrue(isNoToDoMassageIsDisplayed);

    }
}
