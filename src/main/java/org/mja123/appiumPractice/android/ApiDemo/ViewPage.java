package org.mja123.appiumPractice.android.ApiDemo;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.TouchAction;
import org.mja123.appiumPractice.android.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ViewPage extends BasePage {
    private Actions actions;
    public ViewPage(AppiumDriver driver) {
        super(driver);
    }

    public void scrollToElement() {
        int height = driver.manage()
                .window()
                .getSize()
                .getHeight();

        actions = new Actions(driver);
        actions.scrollByAmount(600, 450).perform();
        //actions.scrollByAmount((int) (height * 0.8), (int) (height * 0.1)).perform();

        WebElement switchPage = driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("Picker"));
        System.out.println(switchPage);
    }
}
