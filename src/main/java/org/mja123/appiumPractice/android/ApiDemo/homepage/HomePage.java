package org.mja123.appiumPractice.android.ApiDemo.homepage;

import io.appium.java_client.AppiumDriver;
import org.mja123.appiumPractice.android.ApiDemo.view.ViewPage;
import org.mja123.appiumPractice.android.BasePage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class HomePage extends BasePage {

    public HomePage(AppiumDriver driver)
    {
        super(driver);
    }

    public BasePage selectView(EHomeOptions view) throws ElementNotFound {

        filterByText(view).click();
        return switch (view) {
            case VIEW -> new ViewPage(driver);
        };
    }

    private WebElement filterByText(EHomeOptions view) throws ElementNotFound {
        List<WebElement> views = driver.findElements(By.className("android.widget.TextView"));

        Optional<WebElement> targetView = views.stream()
                .filter(v -> v.getText().equals(view.getText()))
                .findFirst();

        if (targetView.isPresent()) {
            return targetView.get();
        }
        throw new ElementNotFound("View " + view + " not found");
    }
}
