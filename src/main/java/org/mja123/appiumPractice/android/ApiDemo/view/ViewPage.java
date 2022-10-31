package org.mja123.appiumPractice.android.ApiDemo.view;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.mja123.appiumPractice.android.ApiDemo.view.progressBar.ProgressBarPage;
import org.mja123.appiumPractice.android.BasePage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.openqa.selenium.WebElement;

public class ViewPage extends BasePage {

    public ViewPage(AppiumDriver driver) {
        super(driver);
    }


    public BasePage selectView(EViews view) throws ElementNotFound {
        scrollToElementUiScrollable(view.getValue()).click();
        LOGGER.info("View clicked");

        return switch (view) {
            case DRAG_DROP -> new DragAndDropPage(driver);
            case WEB_VIEW -> new WebViewPage(driver);
            case PROGRESS_BAR -> new ProgressBarPage(driver);
            default -> throw new ElementNotFound("view not found");
        };
    }
}
