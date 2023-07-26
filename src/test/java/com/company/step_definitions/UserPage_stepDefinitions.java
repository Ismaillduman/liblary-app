package com.company.step_definitions;

import com.company.pages.BasePage;
import com.company.pages.UserPage;
import com.company.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UserPage_stepDefinitions extends BasePage {
    UserPage userPage = new UserPage();

    WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

    @Given("I click on {string} link")
    public void i_click_on_link(String string) {
        wait.until(ExpectedConditions.elementToBeClickable(usersLink));
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

    @Then("show records default value should be {int}")
    public void showRecordsDefaultValueShouldBe(int defaultValue) {
        Select dropDown= new Select(userPage.default_record);
        int actualDefaultValue= Integer.parseInt(dropDown.getFirstSelectedOption().getText());
        Assert.assertEquals("Not match the values",defaultValue, actualDefaultValue);
    }

    @And("show records should have following options")
    public void showRecordsShouldHaveFollowingOptions(List<String> expectedDefault) {
        Select dropDown= new Select(userPage.default_record);
        List<String> actualDefaultValues= new ArrayList<>();
        for (WebElement eachOption : dropDown.getOptions()) {
            actualDefaultValues.add(eachOption.getText());
        }
        Assert.assertEquals(expectedDefault,actualDefaultValues);
    }
}
