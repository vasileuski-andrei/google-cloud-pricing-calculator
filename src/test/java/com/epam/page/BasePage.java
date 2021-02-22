package com.epam.page;

import com.epam.driver.DriverSingleton;
import com.epam.waits.WaitingForEvents;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected WaitingForEvents waitingForEvents;
    protected final Logger logger = LogManager.getRootLogger();

    public BasePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        waitingForEvents = new WaitingForEvents(driver);
    }

}
