package org.mja123.appiumPractice.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class BasePage {
    protected AppiumDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    protected BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    protected WebElement filterElement(String enumValue, List<WebElement> elements) throws ElementNotFound {

        LOGGER.info("Filtering elements");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(elements.get(0)));

        Optional<WebElement> target = elements.stream()
                .filter(v -> v.getText().equals(enumValue))
                .findFirst();

        if (target.isPresent()) {
            return target.get();
        }
        throw new ElementNotFound("Element " + enumValue + " not found");
    }

    protected WebElement scrollToElementUiScrollable(String text) {
        LOGGER.info("Scrolling searching " + text);
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
    }
    protected void explicitClickableWait(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
