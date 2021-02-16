package com.epam.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenMinutePage extends BasePage {

    @FindBy(xpath = "//div[@id='copy_address']")
    private WebElement copiedEmailAddress;

    @FindBy(xpath = "//table[@class='quote']//td[not(@colspan)]/h3")
    private WebElement estimatedBill;

    @FindBy(xpath = "//div[@class='message_top']")
    private WebElement inboxLetter;

    public void copyEmailAddress() {
        waitingForEvents.waitForAppearanceElementAndClick(copiedEmailAddress);
    }

    public void waitForALetter() {
        waitingForEvents.waitForAppearanceElementAndClick(inboxLetter);
    }

    public String getEstimatedCostPerMonthFromEmail() {
        return estimatedBill.getText();
    }

}
