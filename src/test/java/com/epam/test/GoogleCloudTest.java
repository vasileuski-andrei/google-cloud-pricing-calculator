package com.epam.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudTest extends BaseTest {

    @Test
    public void testPricingCalculator() {

        homePage = navigationService.openPage("https://cloud.google.com/");
        Assert.assertTrue(navigationService.isWebsiteCorrect());
        pricingCalculatorPage = homePage.searchPricingCalculatorPage("Google Cloud Platform Pricing Calculator");
        pricingCalculatorPage.fillInFields();

        emailYourEstimatePage = pricingCalculatorPage.clickEmailEstimateButton();
        emailYourEstimatePage.waitForAppearanceOfEmailYourEstimateForm();

        navigationService.openNewTab();
        navigationService.switchToNextTab();
        tenMinutePage = navigationService.openPage("https://10minutemail.com");
        tenMinutePage.copyEmailAddress();

        navigationService.switchToPreviousTab();
        pricingCalculatorPage.switchToFrame("myFrame");
        navigationService.pasteCopiedData(emailYourEstimatePage.getEmailField());

        emailYourEstimatePage.clickSendEmailButton();

        navigationService.switchToNextTab();
        tenMinutePage.waitForALetter();
        String estimatedCostPerMonthFromEmail = tenMinutePage.getEstimatedCostPerMonthFromEmail();

        navigationService.switchToPreviousTab();
        pricingCalculatorPage.switchToFrame("myFrame");

        Assert.assertTrue(pricingCalculatorPage.isCorrect(estimatedCostPerMonthFromEmail));

    }

}
