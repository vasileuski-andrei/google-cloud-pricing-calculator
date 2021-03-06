package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchFieldAndButton;

    @FindBy(xpath = "//div[@class='gs-title']/a[@href='https://cloud.google.com/products/calculator']")
    private WebElement searchResult;

    public void inputSearchText(String searchText) {
        searchFieldAndButton.sendKeys(searchText, Keys.ENTER);
    }

    public void waitSearchResults() {
        waitingForEvents.waitForAppearanceElementLocatedBy(By.xpath("//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']"));
    }

    public PricingCalculatorPage searchPricingCalculatorPage(String webPage) {
        waitingForEvents.waitForAppearanceElementAndClick(searchFieldAndButton);
        inputSearchText(webPage);
        waitSearchResults();
        searchResult.click();
        return new PricingCalculatorPage();
    }

}
