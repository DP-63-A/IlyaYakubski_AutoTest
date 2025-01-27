package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.RegistrationPage;
import com.stv.factory.utils.UserDataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//After an account is created, click Log Out to perform login test
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class FactoryTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private static String username;
    private static String userPassword;
    private static final Logger LOGGER = Logger.getLogger(FactoryTest.class.getName());

    @BeforeClass
    public void setUp() {
        LOGGER.info("Setting up WebDriver...");
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
            LOGGER.info("WebDriver setup complete.");

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during WebDriver setup: ", e);
            throw e;
        }
    }

    @Test(description = "Registration test with valid data")
    public void testRegistration() {
        try {
            LOGGER.info("Starting registration test...");
            driver.get("https://parabank.parasoft.com/parabank/register.htm");
            RegistrationPage registrationPage = new RegistrationPage(driver);

            username = UserDataGenerator.generateUsername(12);
            userPassword = UserDataGenerator.generateUserPassword();
            String firstName = UserDataGenerator.generateName(8);
            String lastName = UserDataGenerator.generateSurname(10);
            String address = UserDataGenerator.generateAddress();
            String city = UserDataGenerator.generateName(6);
            String state = UserDataGenerator.generateState();
            String zipCode = UserDataGenerator.generateZipCode();
            String phoneNumber = UserDataGenerator.generatePhoneNumber();
            String ssn = UserDataGenerator.generateSSN();

            registrationPage.enterFirstName(firstName)
                    .enterLastName(lastName)
                    .enterAddress(address)
                    .enterCity(city)
                    .enterState(state)
                    .enterZipCode(zipCode)
                    .enterPhoneNumber(phoneNumber)
                    .enterSSN(ssn)
                    .enterUsername(username)
                    .enterPassword(userPassword)
                    .enterConfirmPassword(userPassword)
                    .clickRegisterButton();

            Assert.assertTrue(driver.getTitle().contains("ParaBank | Customer Created"), "Registration failed");
            LOGGER.info("Registration test passed.");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during registration test: ", e);
            throw e;
        }
    }

    @Test(description = "Login test with generated credentials", dependsOnMethods = "testRegistration")
    public void testLogin() {
        try {
            LOGGER.info("Starting login test...");
            driver.get("https://parabank.parasoft.com/parabank/index.htm");
            LoginPage loginPage = new LoginPage(driver);

            loginPage.enterUsername(username)
                    .enterPassword(userPassword)
                    .clickLoginButton();

            Assert.assertTrue(driver.getTitle().contains("ParaBank | Accounts Overview"), "Login failed");
            LOGGER.info("Login test passed.");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during login test: ", e);
            throw e;
        }
    }

    @AfterClass
    public void tearDown() {
        LOGGER.info("Tearing down WebDriver...");
        if (driver != null) {
            driver.quit();
        }
        LOGGER.info("WebDriver closed.");
    }
}