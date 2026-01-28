package com.qacart.todo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        //PageFactory.initElements() is a Selenium WebDriver method used to initialize web elements annotated with @FindBy within Page Object Model (POM) classes. By calling this in a constructor, elements are lazy-loaded as proxies and initialized only when acted upon, preventing NullPointerExceptions and reducing overhead
        PageFactory.initElements(driver,this);
    }

}
