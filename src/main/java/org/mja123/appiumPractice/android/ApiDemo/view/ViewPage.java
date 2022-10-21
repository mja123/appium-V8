package org.mja123.appiumPractice.android.ApiDemo.view;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.mja123.appiumPractice.android.BasePage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.openqa.selenium.WebElement;

public class ViewPage extends BasePage{

    public ViewPage(AppiumDriver driver) {
        super(driver);
    }

   public WebElement scrollToElementUiScrollable(String text) {
        LOGGER.info("Scrolling searching " + text);
        return driver.findElement(AppiumBy.androidUIAutomator(
      "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
                    ));
    }
    public BasePage selectView(EViews view) throws ElementNotFound {
        scrollToElementUiScrollable(view.getValue()).click();
        LOGGER.info("View clicked");

        return switch (view) {
            case DRAG_DROP -> new DragAndDropPage(driver);
            case WEB_VIEW -> new WebViewPage(driver);
            default -> throw new ElementNotFound("view not found");
        };
    }


//    public void scrollToElementAction() {
//        Actions actions = new Actions(driver);
//        Point start = driver.manage().window().getPosition();
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//        Sequence scroll = new Sequence(finger, 1);
//        scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(), start.y));
//        scroll.addAction(finger.createPointerDown(0));
//        driver.perform(List.of(scroll));
//    }
}
