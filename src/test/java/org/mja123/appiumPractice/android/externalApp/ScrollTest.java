package org.mja123.appiumPractice.android.externalApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.mja123.appiumPractice.BaseTest;
import org.mja123.appiumPractice.android.ApiDemo.ViewPage;
import org.mja123.appiumPractice.android.ApiDemo.homepage.EViews;
import org.mja123.appiumPractice.android.ApiDemo.homepage.HomePage;
import org.mja123.appiumPractice.android.builtIn.clockApp.component.ElementNotFound;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class ScrollTest extends BaseTest {

    @Test
    public void scrollWithUiScrollableToElement() throws ElementNotFound {
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage =  (ViewPage) homePage.selectView(EViews.VIEW);

        viewPage.scrollToElementUiScrollable("TextClock");
    }

    @Test
    public void scrollWithActionsToElement() throws ElementNotFound {
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage =  (ViewPage) homePage.selectView(EViews.VIEW);

        viewPage.scrollToElementAction();
    }
}
