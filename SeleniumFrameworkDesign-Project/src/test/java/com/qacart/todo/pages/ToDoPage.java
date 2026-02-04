package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.configer.EndPoints;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoPage extends BasePage {

    public ToDoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[data-testid=\"welcome\"]")
    private WebElement welcomeMassage;

    @FindBy(css="[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css="[data-testid=\"todo-text\"]")
    private WebElement todoItem;

    @FindBy(css="[data-testid=\"delete\"]")
    private WebElement deleteButton;

    @FindBy(css="[data-testid=\"no-todos\"]")
    private WebElement noTodosMassage;

    @Step("Check if the welcome massage is displayed ")
    public boolean isWelcomeMassageDisplayed()
    {
        return welcomeMassage.isDisplayed();
    }

    @Step
    public NewToDoPage clickOnPlusButton()
    {
        addButton.click();
        return new NewToDoPage(driver);
    }

    @Step
    public String getTodoText()
    {
        return todoItem.getText();
    }

    @Step
    public ToDoPage clickOnDeleteButton()
    {
        deleteButton.click();
        return this;
    }

    @Step
    public boolean isNoTodoMassageDisplayed()
    {
       return noTodosMassage.isDisplayed();
    }

    @Step
    public ToDoPage load()
    {
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoints.API_TODO_ENDPOINT);
        return this;
    }
}
