package org.mja123.appiumPractice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected AppiumDriver driver;

    protected BasePage(AppiumDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
