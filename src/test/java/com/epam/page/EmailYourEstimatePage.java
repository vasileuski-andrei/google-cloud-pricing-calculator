package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailYourEstimatePage extends BasePage {

    @FindBy (xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains (text(), 'Send Email') and not(@disabled='disabled')]")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//form[@name='emailForm']")
    private WebElement emailYourEstimateForm;

    public void clickSendEmailButton() {
        waitingForEvents.waitForAppearanceElementLocatedBy(By.xpath("//input[@type='email' and @aria-invalid='false']"));
        waitingForEvents.waitForAppearanceElementAndClick(sendEmailButton);
    }

    public void waitForAppearanceOfEmailYourEstimateForm() {
        waitingForEvents.waitForAppearanceElement(emailYourEstimateForm);
    }

    public WebElement getEmailField() {
        return emailField;
    }

}
