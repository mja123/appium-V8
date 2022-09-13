package org.mja123.appiumPractice.builtIn.clockApp.component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.mja123.appiumPractice.BasePage;
import org.mja123.appiumPractice.builtIn.clockApp.alarm.AlarmHomePage;
import org.mja123.appiumPractice.builtIn.clockApp.clock.ClockHomePage;
import org.mja123.appiumPractice.builtIn.clockApp.stopwatch.StopwatchHomePage;
import org.mja123.appiumPractice.builtIn.clockApp.timer.TimerHomePage;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.Optional;

public class Header extends BasePage {
    @AndroidFindBy(className = "nh")
    public List<RemoteWebElement> headerOptions;

    public Header(AppiumDriver driver) {
        super(driver);
    }

    public BasePage selectOption(EHeaderOptions option) throws ElementNotFound {
        selectOptionElement(option).click();

        switch (option) {
            case ALARM:
                return new AlarmHomePage(driver);
            case TIMER:
                return new TimerHomePage(driver);
            case STOPWATCH:
                return new StopwatchHomePage(driver);
            default:
                return new ClockHomePage(driver);

        }
    }
    private RemoteWebElement selectOptionElement(EHeaderOptions option) throws ElementNotFound {

        Optional<RemoteWebElement> optionTarget = headerOptions.stream()
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
