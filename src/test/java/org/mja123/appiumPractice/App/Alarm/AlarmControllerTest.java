package org.mja123.appiumPractice.App.Alarm;

import static io.appium.java_client.AppiumBy.*;
import org.mja123.appiumPractice.BaseAndroidTest;
import org.testng.annotations.Test;

public class AlarmControllerTest extends BaseAndroidTest {

    @Test
    public void accessToAlarmController() {
        driver.findElement(accessibilityId("App")).click();
        //driver.findElement(accessibilityId("Alarm")).click();
    }
}
