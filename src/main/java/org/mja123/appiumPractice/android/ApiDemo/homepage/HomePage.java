package org.mja123.appiumPractice.android.ApiDemo.homepage;

import io.appium.java_client.AppiumDriver;
import org.mja123.appiumPractice.android.ApiDemo.view.ViewPage;
import org.mja123.appiumPractice.android.BasePage;
import org.mja123.appiumPractice.android.ElementNotFound;

public class HomePage extends BasePage {

    public HomePage(AppiumDriver driver)
    {
        super(driver);
    }

    public BasePage selectPage(EHomeOptions view) throws ElementNotFound {

        scrollToElementUiScrollable(view.getText()).click();

        return switch (view) {
            case VIEW -> new ViewPage(driver);
        };
    }

}
