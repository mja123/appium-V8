package org.mja123.appiumPractice.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected AppiumDriver driver;

    protected BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

}
