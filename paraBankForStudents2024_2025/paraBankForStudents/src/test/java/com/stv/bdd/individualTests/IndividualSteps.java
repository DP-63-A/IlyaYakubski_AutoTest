package com.stv.bdd.individualTests;

import com.stv.bdd.factorypages.CustomerCarePage;
import com.stv.bdd.factorypages.HomePage;
import com.stv.bdd.tests.Factory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class IndividualSteps {
    WebDriver driver = Factory.getDriver();
    CustomerCarePage customerCarePage = new CustomerCarePage(driver);
    HomePage homePage = new HomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("I am on the Login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Then("I should see the Envelope button")
    public void iShouldSeeTheEnvelopeButton() {
        Assert.assertTrue("Envelope button is not displayed", customerCarePage.isEnvelopeButtonDisplayed());
    }

    @And("I click the Envelope button")
    public void iClickTheEnvelopeButton() {
        customerCarePage.clickEnvelopeButton();
    }

    @Then("I should see the SEND TO CUSTOMER CARE button")
    public void iShouldSeeTheSendToCustomerCareButton() {
        Assert.assertTrue("Send to Customer Care button is not displayed", customerCarePage.isSendToCustomerCareButtonDisplayed());
    }

    @And("I click the SEND TO CUSTOMER CARE button")
    public void iClickTheSendToCustomerCareButton() {
        customerCarePage.clickSendToCustomerCareButton();
    }

    @Then("I should see four error messages")
    public void iShouldSeeFourErrorMessages() {
        Assert.assertEquals("Expected 4 error messages", 4, customerCarePage.getNumberOfErrorMessages());
    }

    @Then("I click the Envelope button again")
    public void iClickTheEnvelopeButtonAgain() {
        customerCarePage.clickEnvelopeButton();
    }

    @And("I should see no error messages")
    public void iShouldSeeNoErrorMessages() {
        Assert.assertEquals("Expected 0 error messages", 0, customerCarePage.getNumberOfErrorMessages());
    }

    @Then("I click on the site logo")
    public void iClickOnTheSiteLogo() {
        homePage.clickLogo();
    }

    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage() {
        String expectedUrl = "https://parabank.parasoft.com/parabank/index.htm";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Did not navigate to home page!", expectedUrl, actualUrl);
    }
}
