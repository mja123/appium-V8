package org.mja123.appiumPractice.android.externalApp;

import org.mja123.appiumPractice.BaseTest;
import org.mja123.appiumPractice.android.ApiDemo.homepage.EHomeOptions;
import org.mja123.appiumPractice.android.ApiDemo.homepage.HomePage;
import org.mja123.appiumPractice.android.ApiDemo.view.EViews;
import org.mja123.appiumPractice.android.ApiDemo.view.ViewPage;
import org.mja123.appiumPractice.android.ApiDemo.view.progressBar.IncrementalBarPage;
import org.mja123.appiumPractice.android.ApiDemo.view.progressBar.ProgressBarPage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest {


    @Test
    public void fullProgressBar() throws ElementNotFound {

        LOGGER.info("Starting fullProgressBar");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        ProgressBarPage progressBarPage = (ProgressBarPage) viewPage.selectView(EViews.PROGRESS_BAR);

        IncrementalBarPage incrementalBarPage = (IncrementalBarPage) progressBarPage
                .selectProgressOption("1. Incremental");

        incrementalBarPage.maxBar();

        Assert.assertEquals(incrementalBarPage.getProgressBar(), "100.0");
    }

    @Test
    public void emptyProgressBar() throws ElementNotFound {

        LOGGER.info("Starting emptyProgressBar");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        ProgressBarPage progressBarPage = (ProgressBarPage) viewPage.selectView(EViews.PROGRESS_BAR);

        IncrementalBarPage incrementalBarPage = (IncrementalBarPage) progressBarPage
                .selectProgressOption("1. Incremental");

        incrementalBarPage.minBar();

        Assert.assertEquals(incrementalBarPage.getProgressBar(), "0.0");
    }

}
