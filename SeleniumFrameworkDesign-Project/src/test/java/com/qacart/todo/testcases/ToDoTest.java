package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import com.qacart.todo.utils.ConfigUtils;
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

    @Test (enabled = false)
    public void shouldBeAbleToDeleteToDo()
    {
        LoginPage loginPage = new LoginPage(driver);
        boolean isNoToDoMassageIsDisplayed=
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .clickOnPlusButton()
                        .addNewTask("Learn Selenium")
                        .clickOnDeleteButton()
                        .isNoTodoMassageDisplayed();

        Assert.assertTrue(isNoToDoMassageIsDisplayed);

    }
}
