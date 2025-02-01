package com.stv.bdd.tests;

import com.stv.bdd.factorypages.HomePage;
import com.stv.bdd.factorypages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    WebDriver driver = Factory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Given("I am on the Login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Then("I should see the LOG IN button")
    public void iShouldSeeTheLoginButton() {
        Assert.assertTrue("Login button is not displayed", loginPage.isLoginButtonDisplayed());
    }

    @When("I enter {string} and {string}")
    public void iEnterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the LOG IN button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see {string}")
    public void iShouldSeeMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.getErrorMessage());
    }

    @When("I log out")
    public void iLogOut() {
        homePage.clickLogOut();
    }
}