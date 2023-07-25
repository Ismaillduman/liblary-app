package com.company.step_definitions;

import com.company.pages.BasePage;
import com.company.pages.UserPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UserPage_stepDefinitions extends BasePage {
    UserPage userPage = new UserPage();

    @Given("I click on {string} link")
    public void i_click_on_link(String string) {
        usersLink.click();
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> dataTable) {

        List<String> actual_list = new ArrayList<>();
        for (WebElement eachWebElement : userPage.table_headers) {
            String element= eachWebElement.getText();
            actual_list.add(element);
        }
        Assert.assertEquals(dataTable,actual_list);

    }

}
