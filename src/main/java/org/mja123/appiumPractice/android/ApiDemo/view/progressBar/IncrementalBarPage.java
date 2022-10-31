package org.mja123.appiumPractice.android.ApiDemo.view.progressBar;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.mja123.appiumPractice.android.BasePage;
import org.mja123.appiumPractice.android.OutOfRangeException;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class IncrementalBarPage extends BasePage {

    private final WebElement progressBar;
    private final WebElement increaseButton;
    private final WebElement decreaseButton;
    public IncrementalBarPage(AppiumDriver driver) {
        super(driver);

        progressBar = driver.findElement(AppiumBy.id("progress_horizontal"));
        increaseButton = driver.findElement(AppiumBy.id("increase"));
        decreaseButton = driver.findElement(AppiumBy.id("decrease"));
    }

    public void decreaseMainBar(int taps) throws OutOfRangeException {
        LOGGER.info("Tapping - button");
        if (taps < 0) {
            throw new OutOfRangeException(taps + " is out of range");
        }

        moveBar(decreaseButton, taps);
    }
    public void increaseMainBar(int taps) throws OutOfRangeException {
        LOGGER.info("Tapping + button");
        if (taps < 0) {
            throw new OutOfRangeException(taps + " is out of range");
        }

        moveBar(increaseButton, taps);
    }

    public void maxBar() {
        LOGGER.info("Tapping + button");
        boolean max = false;
        String lastBarScore = getProgressBar();

        while (!max) {
            increaseButton.click();
            String currentScoreBar = getProgressBar();

            if (lastBarScore.equals(currentScoreBar)) {
                max = true;
            } else {
                lastBarScore = currentScoreBar;
            }
        }
    }

    public void minBar() {
        boolean min = false;
        String lastBarScore = getProgressBar();

        LOGGER.info("Tapping - button");

        while (!min) {
            decreaseButton.click();
            String currentScoreBar = getProgressBar();

            if (lastBarScore.equals(currentScoreBar)) {
                min = true;
            } else {
                lastBarScore = currentScoreBar;
            }
        }
    }
    private void moveBar(WebElement button, int taps) {
        for (int i = 0; i < taps; i++) {
            button.click();
        }
    }

    public String getProgressBar() {
        return progressBar.getText();
    }
}
