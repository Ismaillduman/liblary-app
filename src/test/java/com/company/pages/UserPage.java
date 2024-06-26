package com.company.pages;

import com.company.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserPage {
    public UserPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> table_headers;

    @FindBy(css = "[name='tbl_users_length']")
    public WebElement default_record;

    @FindBy(css = "[name='tbl_users_length']")
    public WebElement default_record1;
}
