package org.mja123.appiumPractice.android.ApiDemo.view.progressBar;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.mja123.appiumPractice.android.BasePage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProgressBarPage extends BasePage {

    private final List<WebElement> progressOptions;
    public ProgressBarPage(AppiumDriver driver) {
        super(driver);
        progressOptions = driver.findElements(AppiumBy.id("android:id/text1"));
    }

    public BasePage selectProgressOption(String target) throws ElementNotFound {

        filterElement(target, progressOptions).click();

        if (target.equalsIgnoreCase("1. Incremental")) {
            return new IncrementalBarPage(driver);
        } else {
            return new DialogsPage(driver);
        }
    }
}
