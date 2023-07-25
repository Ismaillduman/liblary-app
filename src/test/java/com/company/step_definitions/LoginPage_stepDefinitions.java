package com.company.step_definitions;

import com.company.pages.DashboardPage;
import com.company.pages.LoginPage;
import com.company.utilities.BrowserUtils;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_stepDefinitions {


    LoginPage loginPage = new LoginPage();

    DashboardPage dashboardPage = new DashboardPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

    @Given("Given I am on the login page")
    public void given_i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
        wait.until(ExpectedConditions.titleContains("Login - Library"));
        BrowserUtils.verifyTitleContains("Login - Library");
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {

        loginPage.email_box.sendKeys(ConfigurationReader.getProperty("lib22_user"));
        loginPage.password_box.sendKeys(ConfigurationReader.getProperty("lib22_pass"), Keys.ENTER);


    }

    @Then("I should be able to see {string} dashboard page")
    public void iShouldBeAbleToSeeDashboardPage(String dashboard) {
        BrowserUtils.verifyTitleContains(dashboard);
    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String email, String password) {
        loginPage.email_box.sendKeys(email);
        loginPage.password_box.sendKeys(password, Keys.ENTER);
    }

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String name) {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.names));
        Assert.assertEquals("Not match the names", dashboardPage.names.getText(), name);
    }


}
