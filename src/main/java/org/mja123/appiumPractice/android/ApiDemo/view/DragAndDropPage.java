package org.mja123.appiumPractice.android.ApiDemo.view;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.mja123.appiumPractice.android.BasePage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DragAndDropPage extends BasePage {
    private List<WebElement> dots;
    protected DragAndDropPage(AppiumDriver driver) {
        super(driver);
        dotsInstantiation();
    }

    public void dragAndDropDot(int source, int destination) throws ElementNotFound {
        if (source < 0 || source >= dots.size() || destination < 0 || destination >= dots.size()) {
            throw new ElementNotFound("Source and/or destination values out of range");
        }

        Rectangle sourceRectangle = dots.get(source).getRect();
        Rectangle destinationRectangle = dots.get(destination).getRect();

        // middle source dot in x and y
        List<Integer> sourceCoordinates = List.of((sourceRectangle.x + (sourceRectangle.width / 2)),
                (sourceRectangle.y + ((sourceRectangle.height / 2))));
        // middle destination dot in x and y
        List<Integer> destinationCoordinates = List.of((destinationRectangle.x + (destinationRectangle.width / 2)),
                (destinationRectangle.y + (destinationRectangle.height / 2)));

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 0);

        sequence.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), sourceCoordinates.get(0), sourceCoordinates.get(1)));
        sequence.addAction(finger.createPointerDown(0));
        sequence.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), destinationCoordinates.get(0), destinationCoordinates.get(1)));
        sequence.addAction(finger.createPointerUp(0));

        driver.perform(List.of(sequence));
    }


    public String displayResultText() {
        return driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
    }

    private void dotsInstantiation() {
        dots = new ArrayList<>();


        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(AppiumBy.id("io.appium.android.apis:id/drag_dot_1")));

        final int DOTS_COUNT = 3;

        for (int i = 0; i < DOTS_COUNT; i++) {
            dots.add(driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_" + (i + 1))));
        }
    }


}
