package com.epam.test;

import com.epam.service.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudTest extends BaseTest {

    @Test
    public void testPricingCalculator() {

        String virtualMachineClass = "Regular";
        String instanceType = "n1-standard-8";
        String dataCenterLocation = TestData.getDataCenterLocationFromProperty();
        String localSSD = "2x375";
        String numberOfInstances = "4";
        String operatingSystemAndSoftware = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
        String series = "N1";
        String typeGPU = "NVIDIA Tesla V100";
        String commitedUsage = "1 Year";
        String expectedEstimatedCostPerMonth = TestData.getEstimatedCostFromProperty();

        homePage = navigationService.openPage("https://cloud.google.com/");
        Assert.assertTrue(navigationService.isWebsiteCorrect());
        pricingCalculatorPage = homePage.searchPricingCalculatorPage("Google Cloud Platform Pricing Calculator");
        pricingCalculatorPage.switchToFrame("myFrame")
                .clickSectionComputeEngine()
                .inputNumberOfInstances(numberOfInstances)
                .selectElementFromMenuOperatingSystemAndSoftware(operatingSystemAndSoftware)
                .selectElementFromMenuMachineClass(virtualMachineClass)
                .selectElementFromMenuSeries(series)
                .selectElementFromMenuMachineType(instanceType)
                .selectCheckBoxAddGPU()
                .selectElementFromMenuNumberOfGPU()
                .selectElementFromMenuTypeGPU(typeGPU)
                .selectElementFromMenuLocalSSD(localSSD)
                .selectElementFromMenuDatacenterLocation(dataCenterLocation)
                .selectElementFromMenuCommitedUsage(commitedUsage)
                .clickAddToEstimateButton();

        emailYourEstimatePage = pricingCalculatorPage.clickEmailEstimateButton();
        emailYourEstimatePage.waitForAppearanceOfEmailYourEstimateForm();

//        navigationService.openNewTab();
//        navigationService.switchToNextTab();
//        tenMinutePage = navigationService.openPage("https://10minutemail.com");
//        tenMinutePage.copyEmailAddress();
//
//        navigationService.switchToPreviousTab();
//        pricingCalculatorPage.switchToFrame("myFrame");
//        navigationService.pasteCopiedData(emailYourEstimatePage.getEmailField());
//
//        emailYourEstimatePage.clickSendEmailButton();
//
//        navigationService.switchToNextTab();
//
//        tenMinutePage.waitForALetter();
//        String estimatedCostPerMonthFromEmail = tenMinutePage.getEstimatedCostPerMonthFromEmail();
//
//        navigationService.switchToPreviousTab();
//        pricingCalculatorPage.switchToFrame("myFrame");

        Assert.assertTrue(pricingCalculatorPage.isVirtualMachineClassCorrect(virtualMachineClass));
        Assert.assertTrue(pricingCalculatorPage.isInstanceTypeCorrect(instanceType));
        Assert.assertTrue(pricingCalculatorPage.isDataCenterLocationCorrect(dataCenterLocation));
        Assert.assertTrue(pricingCalculatorPage.isLocalSSDCorrect(localSSD));
        Assert.assertTrue(pricingCalculatorPage.isCommitmentTermCorrect(commitedUsage));
        Assert.assertTrue(pricingCalculatorPage.isEstimatedCostPerMonthCorrect(expectedEstimatedCostPerMonth));
        //Assert.assertTrue(pricingCalculatorPage.isEstimatedCostPerMonthCorrect(estimatedCostPerMonthFromEmail));

    }

}
