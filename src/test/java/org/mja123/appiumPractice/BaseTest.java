package org.mja123.appiumPractice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;

    @Parameters({"platformName", "automationName", "platformVersion", "deviceName", "app", "packageActivity"})
    @BeforeSuite
    public void setUp(@Optional("Android") String platformName, @Optional("UiAutomator2") String automationName,
                      @Optional("12.0") String platformVersion,
                      @Optional("Android Emulator")  String deviceName,
                      @Optional("com.google.android.deskclock")  String app,
                      @Optional("com.android.deskclock.DeskClock") String packageActivity) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);

        if (packageActivity.equals("")) {
            capabilities.setCapability("app", System.getProperty("user.dir") + app);
        } else {
            capabilities.setCapability("appPackage", app);
            capabilities.setCapability("appActivity", packageActivity);
        }

        if (platformName.equals("Android")) {
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } else {
            driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        }
    }
//
//    @Parameters({"platformVersion", "deviceName", "app"})
//    @BeforeSuite(groups = {"apkApp", "regression"})
//    public void setUpApkApp(@Optional("12.0") String platformVersion,
//    @Optional("Android Emulator") String deviceName, @Optional("/app/ApiDemos-debug.apk") String app) throws MalformedURLException {
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("platformVersion", platformVersion);
//        capabilities.setCapability("deviceName", deviceName);
//        capabilities.setCapability("app", System.getProperty("user.dir") + app);
//        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
//    }
//
//    @Parameters({"platformVersion", "deviceName", "appPackage", "packageActivity"})
//    @BeforeSuite(groups = {"builtInApp", "regression"})
//    public void setUpBuildInaPP(@Optional("12.0") String platformVersion,
//    @Optional("Android Emulator")  String deviceName, @Optional("com.google.android.deskclock")  String appPackage,
//    @Optional("com.android.deskclock.DeskClock") String packageActivity) throws MalformedURLException {
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("platformVersion", platformVersion);
//        capabilities.setCapability("deviceName", deviceName);
//        capabilities.setCapability("appPackage", appPackage);
//        capabilities.setCapability("appActivity", packageActivity);
//        System.out.println("here");
//        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
//    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

//TODO: Create a factory method to call the respective method to set the capabilities and add @BeforeSuite