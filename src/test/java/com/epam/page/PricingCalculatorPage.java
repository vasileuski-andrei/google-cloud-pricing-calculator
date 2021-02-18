package com.epam.page;

import com.epam.service.ComputeEngineCreator;
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

    public void switchToFrame(String frameName) {
        waitingForEvents.waitForAppearanceFrame(0);
        driver.switchTo().frame(frameName);
    }

    public void inputNumberOfInstances(String number) {
        numberOfInstances.sendKeys(number);
    }

    public void selectCheckBoxAddGPU() {
        checkBoxAddGPU.click();
    }

    public void clickSectionComputeEngine() {
        waitingForEvents.waitForAppearanceElementAndClick(sectionComputeEngine);
    }

    public void clickAddToEstimateButton() {
        addToEstimateButton.click();
    }

    public EmailYourEstimatePage clickEmailEstimateButton() {
        emailEstimateButton.click();
        return new EmailYourEstimatePage();
    }

    public void selectElementFromMenuOperatingSystemAndSoftware(String element) {
        waitingForEvents.waitForAppearanceElementAndClick(menuOperatingSystemAndSoftware);
        By operatingSystem = By.xpath("//md-content/md-option/div[contains (text(),'" +element+ "')]");
        waitingForEvents.waitForAppearanceInvisibilityElementLocatedBy(operatingSystem);
        driver.findElement(operatingSystem).click();
    }

    public void selectElementFromMenuMachineClass(String element) {
        waitingForEvents.waitForAppearanceClickableElementAndClick(menuMachineClass);
        waitingForEvents.waitForAppearanceElementLocatedByAndClick(By.xpath("//md-option[@id='select_option_78' or @id='select_option_79']/div[contains (text(),'" +element+ "')]"));
    }

    public void selectElementFromMenuSeries(String element) {
        series.click();
        driver.findElement(By.xpath("//md-option//div[contains (text(),'" +element+ "')]")).click();
    }

    public void selectElementFromMenuMachineType(String element) {
        machineType.click();
        waitingForEvents.waitForAppearanceElementLocatedBy(By.xpath("//md-select-value[@id='select_value_label_60']//div[contains (text(), 'n1')]"));
        driver.findElement(By.xpath("//div[contains (text(),'" +element+ "')]")).click();
    }

    public void selectElementFromMenuNumberOfGPU() {
        waitingForEvents.waitForAppearanceElementLocatedByAndClick(By.xpath("//md-select-value[@id='select_value_label_392']"));
        driver.findElement(By.cssSelector("#select_option_399 > div.md-text.ng-binding")).click();
    }

    public void selectElementFromMenuTypeGPU(String element) {
        waitingForEvents.waitForAppearanceClickableElementAndClick(typeGPU);
        waitingForEvents.waitForAppearanceElementLocatedBy(By.xpath("//md-select[@id='select_396' and @aria-expanded='true']"));
        driver.findElement(By.xpath("//md-option//div[contains (text(),'" +element+ "')]")).click();
    }

    public void selectElementFromMenuLocalSSD(String element) {
        waitingForEvents.waitForAppearanceElementAndClick(localSSD);
        waitingForEvents.waitForAppearanceElementLocatedBy(By.xpath("//md-select[@id='select_355' and @aria-expanded='true']"));
        waitingForEvents.waitForAppearanceElementLocatedByAndClick(By.xpath("//div[contains (text(),'" +element+ "')]"));
    }

    public void selectElementFromMenuDatacenterLocation(String element) {
        waitingForEvents.waitForAppearanceElementAndClick(datacenterLocation);
        waitingForEvents.waitForAppearanceElementLocatedBy(By.xpath("//md-select[@id='select_92' and @aria-expanded='true']"));
        waitingForEvents.waitForAppearanceElementLocatedByAndClick(By.xpath("//md-select-menu[@class='md-overflow']//div[contains (text(),'" +element+ "')]"));
    }

    public void selectElementFromMenuCommitedUsage(String element) {
        commitedUsage.click();
        driver.findElement(By.xpath("//div[@id='select_container_100']//div[text()='" +element+ "']")).click();
    }

    public Boolean isVirtualMachineClassCorrect(String virtualMachineClass) {
        String actualVirtualMachineClass = driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//div[contains (text(), 'VM class: " +virtualMachineClass.toLowerCase()+ "')]")).getText();
        logger.info("EXPECTED: VM class: " + virtualMachineClass + "; ACTUAL: " + actualVirtualMachineClass);
        return ("VM class: " + virtualMachineClass).equalsIgnoreCase(actualVirtualMachineClass);
    }

    public Boolean isInstanceTypeCorrect(String instanceType) {
        String actualInstanceType = driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//div[contains (text(), 'Instance type: " +instanceType+ "')]")).getText();
        logger.info("EXPECTED: Instance type: " + instanceType + "; ACTUAL: " + actualInstanceType);
        return ("Instance type: " + instanceType).equals(actualInstanceType);
    }

    public Boolean isDataCenterLocationCorrect(String region) {
        String actualRegion = driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//div[contains (text(), 'Region: " +region+ "')]")).getText();
        logger.info("EXPECTED: Region: " + region + "; ACTUAL: " + actualRegion);
        return ("Region: " + region).equals(actualRegion);
    }

    public Boolean isLocalSSDCorrect(String localSSD) {
        String actualLocalSSD = driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//div[contains (text(), 'Total available local SSD space " +localSSD+ " GiB')]")).getText();
        logger.info("EXPECTED: Total available local SSD space " + localSSD + " GiB" + "; ACTUAL: " + actualLocalSSD);
        return ("Total available local SSD space " + localSSD + " GiB").equals(actualLocalSSD);
    }

    public Boolean isCommitmentTermCorrect(String commitmentTerm) {
        String actualCommitmentTerm = driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//div[contains (text(), 'Commitment term: " +commitmentTerm+ "')]")).getText();
        logger.info("EXPECTED: Commitment term: " + commitmentTerm + "; ACTUAL: " + actualCommitmentTerm);
        return ("Commitment term: " + commitmentTerm).equals(actualCommitmentTerm);
    }

    public Boolean isEstimatedCostPerMonthCorrect(String cost) {
        String actualCost = driver.findElement(By.xpath("//md-card-content[@id='resultBlock']//h2[@class='md-title']/b[contains (text(), '" +cost+ "')]")).getText();
        logger.info("EXPECTED: Total Estimated Cost: " + cost + " per 1 month" + "; ACTUAL: " + actualCost);
        return ("Total Estimated Cost: " + cost + " per 1 month").equals(actualCost);
    }

    public void fillInFields() {
        computeEngine = ComputeEngineCreator.withCredentialsFromProperty();
        switchToFrame("myFrame");
        clickSectionComputeEngine();
        inputNumberOfInstances(computeEngine.getNumberOfInstances());
        selectElementFromMenuOperatingSystemAndSoftware(computeEngine.getOperatingSystemAndSoftware());
        selectElementFromMenuMachineClass(computeEngine.getVirtualMachineClass());
        selectElementFromMenuSeries(computeEngine.getSeries());
        selectElementFromMenuMachineType(computeEngine.getInstanceType());
        selectCheckBoxAddGPU();
        selectElementFromMenuNumberOfGPU();
        selectElementFromMenuTypeGPU(computeEngine.getTypeGPU());
        selectElementFromMenuLocalSSD(computeEngine.getLocalSSD());
        selectElementFromMenuDatacenterLocation(computeEngine.getDataCenterLocation());
        selectElementFromMenuCommitedUsage(computeEngine.getCommitedUsage());
        clickAddToEstimateButton();
    }

    public Boolean isCorrect(String estimatedCostPerMonthFromEmail) {
        return isVirtualMachineClassCorrect(computeEngine.getVirtualMachineClass()) &&
                isInstanceTypeCorrect(computeEngine.getInstanceType()) &&
                isDataCenterLocationCorrect(computeEngine.getDataCenterLocation()) &&
                isLocalSSDCorrect(computeEngine.getLocalSSD()) &&
                isCommitmentTermCorrect(computeEngine.getCommitedUsage()) &&
                isEstimatedCostPerMonthCorrect(computeEngine.getEstimatedCostPerMonth()) &&
                isEstimatedCostPerMonthCorrect(estimatedCostPerMonthFromEmail);

    }

}