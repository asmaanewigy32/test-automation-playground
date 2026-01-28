package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
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

    @FindBy(css="data-testid=\"todo-text\"]")
    private WebElement todoItem;

    @FindBy(css="[data-testid=\"delete\"]")
    private WebElement deleteButton;

    @FindBy(css="[data-testid=\"no-todos\"]")
    private WebElement noTodosMassage;

    public boolean isWelcomeMassageDisplayed()
    {
        return welcomeMassage.isDisplayed();
    }

    public void clickOnPlusButton()
    {
        addButton.click();
    }

    public String getTodoText()
    {
        return todoItem.getText();
    }

    public void clickOnDeleteButton()
    {
        deleteButton.click();
    }

    public boolean isNoTodoMassageDisplayed()
    {
       return noTodosMassage.isDisplayed();
    }

}
