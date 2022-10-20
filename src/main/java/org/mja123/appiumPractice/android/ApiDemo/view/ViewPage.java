package org.mja123.appiumPractice.android.ApiDemo.view;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.mja123.appiumPractice.android.BasePage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class ViewPage extends BasePage {

    private List<WebElement> screenElements;
    public ViewPage(AppiumDriver driver) {
        super(driver);
        recollectingElementsScrolling();
    }

    public void scrollToElementUiScrollable(String text) {
        driver.findElement(AppiumBy.androidUIAutomator(
      "new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
                    ));

    }
    public BasePage selectView(EViews view) throws ElementNotFound {
        searchElement(view).click();

        return switch (view) {
            case DRAG_DROP -> new DragAndDropPage(driver);
            case WEB_VIEW -> new WebViewPage(driver);
            default -> throw new ElementNotFound("view not found");
        };
    }

    private WebElement searchElement(EViews view) throws ElementNotFound {
        Optional<WebElement> target = screenElements.stream()
                .filter(v -> v.getText().equals(view.getValue()))
                .findFirst();
        if (target.isPresent()) {
            return target.get();
        }
        throw new ElementNotFound("View not found");
    }


    private void recollectingElementsScrolling() {
        screenElements = driver.findElement(AppiumBy.id("list"))
                .findElements(AppiumBy.className("android.widget.TextView"));

        WebElement lastElement;
        do {
            lastElement = screenElements.get(screenElements.size() - 1);
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollToEnd(1)"));

            screenElements = driver.findElement(AppiumBy.id("list"))
                    .findElements(AppiumBy.className("android.widget.TextView"));

        } while (lastElement != screenElements.get(screenElements.size() - 1));
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
