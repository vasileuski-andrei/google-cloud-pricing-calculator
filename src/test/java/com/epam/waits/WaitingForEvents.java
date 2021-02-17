package com.epam.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingForEvents {

    private static final int WAIT_TIMEOUT_SECONDS = 30;
    private WebDriver driver;

    public WaitingForEvents(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForCondition(ExpectedCondition condition) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition);
    }

    private WebElement getWaitedElement(ExpectedCondition condition) {
        return (WebElement) new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition);
    }

    public void waitForAppearanceElement(WebElement element) {
        waitForCondition(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAppearanceElementAndClick(WebElement element) {
        getWaitedElement(ExpectedConditions.visibilityOf(element)).click();
    }

    public void waitForAppearanceClickableElementAndClick(WebElement element) {
        getWaitedElement(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForAppearanceElementLocatedBy(By by) {
        waitForCondition(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForAppearanceElementLocatedByAndClick(By by) {
        getWaitedElement(ExpectedConditions.presenceOfElementLocated(by)).click();
    }

    public void waitForAppearanceInvisibilityElementLocatedBy(By by) {
        waitForCondition(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForAppearanceFrame(int frameLocator) {
        waitForCondition(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

}
