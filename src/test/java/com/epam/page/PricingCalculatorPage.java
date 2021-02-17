package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorPage extends BasePage {

    @FindBy(xpath = "//md-card-content[@id='mainForm']//md-tab-item/div[@title='Compute Engine']")
    private WebElement sectionComputeEngine;

    @FindBy(xpath = "//form//input[@id='input_63']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_56']")
    private WebElement menuOperatingSystemAndSoftware;

    @FindBy(xpath = "//md-select[@id='select_80']")
    private WebElement menuMachineClass;

    @FindBy(xpath = "//md-select[@name='series']")
    private WebElement series;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_60']")
    private WebElement machineType;

    @FindBy(xpath = "//md-checkbox/div[2]")
    private WebElement checkBoxAddGPU;

    @FindBy(xpath = "//md-select[@id='select_396']")
    private WebElement typeGPU;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_354']")
    private WebElement localSSD;

    @FindBy(xpath = "//md-select[@id='select_92']")
    private WebElement datacenterLocation;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_62']")
    private WebElement commitedUsage;

    /**
     * This is the only one of the 12 buttons on this form that doesn't contain a tag "md-icon" so I used this approach to find it.
     */
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[not(md-icon)]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailEstimateButton;

    public PricingCalculatorPage switchToFrame(String frameName) {
        waitingForEvents.waitForAppearanceFrame(0);
        driver.switchTo().frame(frameName);
        return this;
    }

    public PricingCalculatorPage inputNumberOfInstances(String number) {
        numberOfInstances.sendKeys(number);
        return this;
    }

    public PricingCalculatorPage selectCheckBoxAddGPU() {
        checkBoxAddGPU.click();
        return this;
    }

    public PricingCalculatorPage clickSectionComputeEngine() {
        waitingForEvents.waitForAppearanceElementAndClick(sectionComputeEngine);
        return this;
    }

    public PricingCalculatorPage clickAddToEstimateButton() {
        addToEstimateButton.click();
        return this;
    }

    public EmailYourEstimatePage clickEmailEstimateButton() {
        emailEstimateButton.click();
        return new EmailYourEstimatePage();
    }

    public PricingCalculatorPage selectElementFromMenuOperatingSystemAndSoftware(String element) {
        waitingForEvents.waitForAppearanceElementAndClick(menuOperatingSystemAndSoftware);
        By operatingSystem = By.xpath("//md-content/md-option/div[contains (text(),'" +element+ "')]");
        waitingForEvents.waitForAppearanceInvisibilityElementLocatedBy(operatingSystem);
        driver.findElement(operatingSystem).click();
        return this;
    }

    public PricingCalculatorPage selectElementFromMenuMachineClass(String element) {
        waitingForEvents.waitForAppearanceClickableElementAndClick(menuMachineClass);
        waitingForEvents.waitForAppearanceElementLocatedByAndClick(By.xpath("//md-option[@id='select_option_78' or @id='select_option_79']/div[contains (text(),'" +element+ "')]"));
        return this;
    }

    public PricingCalculatorPage selectElementFromMenuSeries(String element) {
        series.click();
        driver.findElement(By.xpath("//md-option//div[contains (text(),'" +element+ "')]")).click();
        return this;
    }

    public PricingCalculatorPage selectElementFromMenuMachineType(String element) {
        machineType.click();
        waitingForEvents.waitForAppearanceElementLocatedBy(By.xpath("//md-select-value[@id='select_value_label_60']//div[contains (text(), 'n1')]"));
        driver.findElement(By.xpath("//div[contains (text(),'" +element+ "')]")).click();
        return this;
    }

    public PricingCalculatorPage selectElementFromMenuNumberOfGPU() {
        waitingForEvents.waitForAppearanceElementLocatedByAndClick(By.xpath("//md-select-value[@id='select_value_label_392']"));
        driver.findElement(By.cssSelector("#select_option_399 > div.md-text.ng-binding")).click();
        return this;
    }

    public PricingCalculatorPage selectElementFromMenuTypeGPU(String element) {
        waitingForEvents.waitForAppearanceClickableElementAndClick(typeGPU);
        waitingForEvents.waitForAppearanceElementLocatedBy(By.xpath("//md-select[@id='select_396' and @aria-expanded='true']"));
        driver.findElement(By.xpath("//md-option//div[contains (text(),'" +element+ "')]")).click();
        return this;
    }

    public PricingCalculatorPage selectElementFromMenuLocalSSD(String element) {
        waitingForEvents.waitForAppearanceElementAndClick(localSSD);
        waitingForEvents.waitForAppearanceElementLocatedBy(By.xpath("//md-select[@id='select_355' and @aria-expanded='true']"));
        waitingForEvents.waitForAppearanceElementLocatedByAndClick(By.xpath("//div[contains (text(),'" +element+ "')]"));
        return this;
    }

    public PricingCalculatorPage selectElementFromMenuDatacenterLocation(String element) {
        waitingForEvents.waitForAppearanceElementAndClick(datacenterLocation);
        waitingForEvents.waitForAppearanceElementLocatedBy(By.xpath("//md-select[@id='select_92' and @aria-expanded='true']"));
        waitingForEvents.waitForAppearanceElementLocatedByAndClick(By.xpath("//md-select-menu[@class='md-overflow']//div[contains (text(),'" +element+ "')]"));
        return this;
    }

    public PricingCalculatorPage selectElementFromMenuCommitedUsage(String element) {
        commitedUsage.click();
        driver.findElement(By.xpath("//div[@id='select_container_100']//div[text()='" +element+ "']")).click();
        return this;
    }

    public Boolean isVirtualMachineClassCorrect(String virtualMachineClass) {
        return ("VM class: " + virtualMachineClass)
                .equalsIgnoreCase(driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//div[contains (text(), 'VM class: " +virtualMachineClass.toLowerCase()+ "')]")).getText());
    }

    public Boolean isInstanceTypeCorrect(String instanceType) {
        return ("Instance type: " + instanceType)
                .equals(driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//div[contains (text(), 'Instance type: " +instanceType+ "')]")).getText());
    }

    public Boolean isDataCenterLocationCorrect(String region) {
        return ("Region: " + region)
                .equals(driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//div[contains (text(), 'Region: " +region+ "')]")).getText());
    }

    public Boolean isLocalSSDCorrect(String localSSD) {
        return ("Total available local SSD space " + localSSD + " GiB")
                .equals(driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//div[contains (text(), 'Total available local SSD space " +localSSD+ " GiB')]")).getText());
    }

    public Boolean isCommitmentTermCorrect(String commitmentTerm) {
        return ("Commitment term: " + commitmentTerm)
                .equals(driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//div[contains (text(), 'Commitment term: " +commitmentTerm+ "')]")).getText());
    }

    public Boolean isEstimatedCostPerMonthCorrect(String cost) {
        return ("Total Estimated Cost: " + cost + " per 1 month")
                .equals(driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//h2[@class='md-title']/b[contains (text(), '" +cost+ "')]")).getText());
    }

}