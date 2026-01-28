package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css ="[data-testid=\"email\"]")
    private WebElement emailInput;

    @FindBy(css ="[data-testid=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css ="[data-testid=\"submit\"]")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void load()
    {
        driver.get("https://qacart-todo.herokuapp.com");
    }
    public ToDoPage login(String email, String password)
    {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new ToDoPage(driver);
    }

}
