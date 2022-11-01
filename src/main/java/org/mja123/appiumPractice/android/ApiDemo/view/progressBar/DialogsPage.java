package org.mja123.appiumPractice.android.ApiDemo.view.progressBar;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.mja123.appiumPractice.android.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DialogsPage extends BasePage {

    public DialogsPage(AppiumDriver driver) {
        super(driver);
    }

    public void loadingScreen() {
        explicitClickableWait(AppiumBy.id("showIndeterminateNoTitle"));

        driver.findElement(AppiumBy.id("showIndeterminateNoTitle")).click();
    }

    public String dialogLoadingText() {
        LOGGER.info("Switching to alert and returning the alert's text");
        return driver.switchTo().alert().getText();
    }

    public void goToMainScreen() {
        LOGGER.info("Touching out of the alert");

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 0);

        Rectangle dialogSize = driver.findElement(AppiumBy.id("android:id/body")).getRect();

        int x = dialogSize.getWidth() / 2;
        int y = dialogSize.getHeight() * 2;

        // click out of the alert
        sequence.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), x, y));
        sequence.addAction(finger.createPointerDown(0));
        sequence.addAction(finger.createPointerUp(0));

        driver.perform(List.of(sequence));

        System.out.println(driver.findElement(AppiumBy.id("showIndeterminateNoTitle")).isEnabled());
    }

    public String pageTitle() {
        return driver.findElement(AppiumBy.className("android.widget.TextView")).getText();
    }
}
