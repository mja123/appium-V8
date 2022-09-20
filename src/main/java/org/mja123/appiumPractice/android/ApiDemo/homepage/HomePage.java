package org.mja123.appiumPractice.android.ApiDemo.homepage;

import io.appium.java_client.AppiumDriver;
import org.mja123.appiumPractice.android.ApiDemo.ViewPage;
import org.mja123.appiumPractice.android.ApiDemo.homepage.EViews;
import org.mja123.appiumPractice.android.BasePage;
import org.mja123.appiumPractice.android.builtIn.clockApp.component.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class HomePage extends BasePage {
//    @FindBy(className = "android.widget.TextView")
//    private List<WebElement> views;

    public HomePage(AppiumDriver driver)
    {
        super(driver);
    }

    public BasePage selectView(EViews view) throws ElementNotFound {

        filterByText(view).click();

        return switch (view) {
            case VIEW -> new ViewPage(driver);
        };
    }

    private WebElement filterByText(EViews view) throws ElementNotFound {
        List<WebElement> views = driver.findElements(By.className("android.widget.TextView"));
        System.out.println(views.size());

        Optional<WebElement> targetView = views.stream()
                .filter(v -> v.getText().equals(view.getText()))
                .findFirst();

        views.forEach(v -> System.out.println(v.getText()));
        if (targetView.isPresent()) {
            return targetView.get();
        }
        throw new ElementNotFound("View " + view + " not found");
    }
}
