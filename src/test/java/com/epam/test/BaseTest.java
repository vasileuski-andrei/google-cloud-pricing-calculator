package com.epam.test;

import com.epam.driver.DriverSingleton;
import com.epam.driver.NavigationService;
import com.epam.page.EmailYourEstimatePage;
import com.epam.page.HomePage;
import com.epam.page.PricingCalculatorPage;
import com.epam.page.TenMinutePage;
import com.epam.service.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected PricingCalculatorPage pricingCalculatorPage;
    protected EmailYourEstimatePage emailYourEstimatePage;
    protected TenMinutePage tenMinutePage;
    protected NavigationService navigationService;

    @BeforeMethod
    public void setup() {
        driver = DriverSingleton.getDriver();
        navigationService = new NavigationService(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        DriverSingleton.closeDriver();
    }

}
