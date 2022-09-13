package org.mja123.appiumPractice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }

}
