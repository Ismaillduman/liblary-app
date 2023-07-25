package com.company.pages;

import com.company.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "inputEmail")
    public WebElement email_box;

    @FindBy(id = "inputPassword")
    public WebElement password_box;

    @FindBy(css = ".btn.btn-lg.btn-primary.btn-block")
    public WebElement login_button;

}
