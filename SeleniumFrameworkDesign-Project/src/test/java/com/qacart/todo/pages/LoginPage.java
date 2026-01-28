package com.qacart.todo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        //PageFactory.initElements() is a Selenium WebDriver method used to initialize web elements annotated with @FindBy within Page Object Model (POM) classes. By calling this in a constructor, elements are lazy-loaded as proxies and initialized only when acted upon, preventing NullPointerExceptions and reducing overhead
        PageFactory.initElements(driver,this);
    }

    @FindBy(css ="[data-testid=\"email\"]")
    private WebElement emailInput;

    @FindBy(css ="[data-testid=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css ="[data-testid=\"submit\"]")
    private WebElement submitButton;

    public void login(String email, String password)
    {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

}
