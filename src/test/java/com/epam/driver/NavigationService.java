package com.epam.driver;

import com.epam.page.BasePage;
import com.epam.page.HomePage;
import com.epam.page.TenMinutePage;
import com.epam.page.UndefinedPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigationService {

    private WebDriver driver;
    private Map<String, BasePage> pageUrl;
    private final Logger logger = LogManager.getRootLogger();

    public NavigationService(WebDriver driver) {
        this.driver = driver;
        pageUrl = new HashMap();
        pageUrl.put("https://cloud.google.com/", new HomePage());
        pageUrl.put("https://10minutemail.com", new TenMinutePage());
    }

    public <T extends BasePage> T openPage(String url) {
        driver.get(url);
        logger.info("Page " + url + " opened");
        if (pageUrl.containsKey(url)) {
            return (T) pageUrl.get(url);
        }
        return (T) new UndefinedPage();
    }

    public void openNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }

    public void switchToNextTab() {
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        int currentTab = tabs.indexOf(driver.getWindowHandle());
        driver.switchTo().window(tabs.get(currentTab + 1));
    }

    public void switchToPreviousTab() {
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        int currentTab = tabs.indexOf(driver.getWindowHandle());
        if (currentTab != 0) {
            driver.switchTo().window(tabs.get(currentTab - 1));
        }
    }

    /**
     * The title of this website contains "non-breaking space" so I used "replace" '\u00a0' to make it easier to read and compare.
     */
    public Boolean isWebsiteCorrect() {
        return driver.getTitle().replace(Character.toString('\u00a0'), "").equals("Cloud Computing Services | Google Cloud");
    }

    public void pasteCopiedData(WebElement field) {
        field.sendKeys(Keys.LEFT_CONTROL + "v");
    }

}
