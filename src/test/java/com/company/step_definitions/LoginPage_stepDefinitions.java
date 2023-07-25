package com.company.step_definitions;

import com.company.pages.DashboardPage;
import com.company.pages.LoginPage;
import com.company.utilities.BrowserUtils;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import io.cucumber.java.en.And;
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

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
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


    @When("I enter username {string}")
    public void iEnterUsername(String arg0) {
        loginPage.email_box.sendKeys(arg0);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String arg0) {
        loginPage.password_box.sendKeys(arg0);
    }

    @And("click the sign in button")
    public void clickTheSignInButton() {
        loginPage.login_button.click();
    }

    @And("there should be {int} users")
    public void thereShouldBeUsers(int expected_count) {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.users_count));
        String expectedUserAccount= String.valueOf(expected_count);

        String actual_count=dashboardPage.users_count.getText();
        System.out.println(actual_count);
        Assert.assertEquals("Not match please fix it!!",expectedUserAccount,actual_count);
    }

    @Then("dashboard should be displayed")
    public void dashboardShouldBeDisplayed() {
        BrowserUtils.verifyTitleContains("Library");
    }
}
