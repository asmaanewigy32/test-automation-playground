package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void shouldBeAbleToLoginWithEmailAndPassword()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcomeDisplayed= loginPage
                                            .load()
                                            .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                                            .isWelcomeMassageDisplayed();

        Assert.assertTrue(isWelcomeDisplayed);

    }
}
