package org.mja123.appiumPractice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseAndroidTest {
    protected AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/app/ApiDemos-debug.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
