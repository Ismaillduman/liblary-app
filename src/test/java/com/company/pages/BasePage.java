package com.company.pages;

import com.company.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Users']")
    public WebElement usersLink;

    @FindBy(linkText = "Dashboard")
    public WebElement dashboardLink;

    @FindBy(linkText = "Books")
    public WebElement booksLink;

}
