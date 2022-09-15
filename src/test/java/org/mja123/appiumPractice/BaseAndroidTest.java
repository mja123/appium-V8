package org.mja123.appiumPractice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseAndroidTest {
    protected AppiumDriver driver;


    @Parameters({"platformVersion", "deviceName", "app"})
    @BeforeSuite(groups = {"apkApp", "regression"})
    public void setUpApkApp(@Optional("12.0") String platformVersion,
    @Optional("Android Emulator") String deviceName, @Optional("/app/ApiDemos-debug.apk") String app) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("app", System.getProperty("user.dir") + app);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Parameters({"platformVersion", "deviceName", "appPackage", "packageActivity"})
    @BeforeSuite(groups = {"builtInApp", "regression"})
    public void setUpBuildInaPP(@Optional("12.0") String platformVersion,
    @Optional("Android Emulator")  String deviceName, @Optional("com.google.android.deskclock")  String appPackage,
    @Optional("com.android.deskclock.DeskClock") String packageActivity) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", packageActivity);
        System.out.println("here");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

//TODO: Create a factory method to call the respective method to set the capabilities and add @BeforeSuite