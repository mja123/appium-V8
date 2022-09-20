package org.mja123.appiumPractice.android.ApiDemo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.TouchAction;
import org.mja123.appiumPractice.android.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ViewPage extends BasePage {
    public ViewPage(AppiumDriver driver) {
        super(driver);
    }

    public void scrollToElementUiScrollable(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
      "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
                    ));

    }
    public void scrollToElementAction() {
        Actions actions = new Actions(driver);
        Point start = driver.manage().window().getPosition();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence scroll = new Sequence(finger, 1);
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(), start.y));
        scroll.addAction(finger.createPointerDown(0));
        driver.perform(List.of(scroll));
    }
}
