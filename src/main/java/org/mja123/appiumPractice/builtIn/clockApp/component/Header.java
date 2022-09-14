package org.mja123.appiumPractice.builtIn.clockApp.component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.mja123.appiumPractice.BasePage;
import org.mja123.appiumPractice.builtIn.clockApp.alarm.AlarmHomePage;
import org.mja123.appiumPractice.builtIn.clockApp.clock.ClockHomePage;
import org.mja123.appiumPractice.builtIn.clockApp.stopwatch.StopwatchHomePage;
import org.mja123.appiumPractice.builtIn.clockApp.timer.TimerHomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class Header extends BasePage {
    @FindBy(className = "nh")
    private List<WebElement> headerOptions;

    public Header(AppiumDriver driver) {
        super(driver);
    }

    public BasePage selectOption(EHeaderOptions option) throws ElementNotFound {
        selectOptionElement(option).click();

        return switch (option) {
            case ALARM -> new AlarmHomePage(driver);
            case TIMER -> new TimerHomePage(driver);
            case STOPWATCH -> new StopwatchHomePage(driver);
            default -> new ClockHomePage(driver);
        };
    }
    private WebElement selectOptionElement(EHeaderOptions option) throws ElementNotFound {

        Optional<WebElement> optionTarget = headerOptions.stream()
                .filter(o -> o
                        .getDomAttribute("content-desc")
                        .equals(option.getVALUE()))
                .findFirst();

        if (optionTarget.isEmpty()) {
            throw new ElementNotFound("Option " + option.getVALUE() + " not found!");
        }
        return optionTarget.get();
    }
}
