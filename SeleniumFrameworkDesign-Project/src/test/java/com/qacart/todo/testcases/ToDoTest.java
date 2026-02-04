package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import junit.framework.Assert;
import org.testng.annotations.Test;


@Feature("Todo")
public class ToDoTest extends BaseTest {

    @Story("Add Todo")
    @Test (description = "Should be able to add a new todo correctly")
    public void shouldBeAbleToAddNewToDo()
    {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        NewToDoPage newToDoPage = new NewToDoPage(getDriver());
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

    @Story("Delete Todo")
    @Test (description = "Should be able to delete todo correctly")
    public void shouldBeAbleToDeleteToDo()
    {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());

        ToDoPage ToDoPage = new ToDoPage(getDriver());
        ToDoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        boolean isNoToDoMassageIsDisplayed = ToDoPage
                .load()
                .clickOnDeleteButton()
                .isNoTodoMassageDisplayed();

        Assert.assertTrue(isNoToDoMassageIsDisplayed);

    }
}
