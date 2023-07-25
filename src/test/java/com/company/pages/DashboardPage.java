package com.company.pages;

import com.company.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id='user_avatar']/following-sibling::span")
    public WebElement names;
}
