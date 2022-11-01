package org.mja123.appiumPractice.android.externalApp;

import org.mja123.appiumPractice.BaseTest;
import org.mja123.appiumPractice.android.ApiDemo.homepage.EHomeOptions;
import org.mja123.appiumPractice.android.ApiDemo.homepage.HomePage;
import org.mja123.appiumPractice.android.ApiDemo.view.EViews;
import org.mja123.appiumPractice.android.ApiDemo.view.ViewPage;
import org.mja123.appiumPractice.android.ApiDemo.view.progressBar.DialogsPage;
import org.mja123.appiumPractice.android.ApiDemo.view.progressBar.IncrementalBarPage;
import org.mja123.appiumPractice.android.ApiDemo.view.progressBar.ProgressBarPage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.mja123.appiumPractice.android.OutOfRangeException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest {
    @Test(groups = {"regression", "incrementalProgressBar"})
    public void incrementProgressBar() throws OutOfRangeException, ElementNotFound {
        LOGGER.info("Starting incrementProgressBar");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        ProgressBarPage progressBarPage = (ProgressBarPage) viewPage.selectView(EViews.PROGRESS_BAR);

        IncrementalBarPage incrementalBarPage = (IncrementalBarPage) progressBarPage
                .selectProgressOption("1. Incremental");

        incrementalBarPage.increaseMainBar(2);
    }
    @Test(groups = {"incrementalProgressBar", "smoke"})
    public void decrementProgressBar() throws OutOfRangeException, ElementNotFound {
        LOGGER.info("Starting decrementProgressBar");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        ProgressBarPage progressBarPage = (ProgressBarPage) viewPage.selectView(EViews.PROGRESS_BAR);

        IncrementalBarPage incrementalBarPage = (IncrementalBarPage) progressBarPage
                .selectProgressOption("1. Incremental");

        incrementalBarPage.decreaseMainBar(3);
    }

    @Test(groups = {"incrementalProgressBar", "smoke"}, expectedExceptions = OutOfRangeException.class)
    public void decrementProgressBarOutOfRange() throws OutOfRangeException, ElementNotFound {
        LOGGER.info("Starting decrementProgressBar");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        ProgressBarPage progressBarPage = (ProgressBarPage) viewPage.selectView(EViews.PROGRESS_BAR);

        IncrementalBarPage incrementalBarPage = (IncrementalBarPage) progressBarPage
                .selectProgressOption("1. Incremental");

        incrementalBarPage.decreaseMainBar(-2);

    }
    @Test(groups = "incrementalProgressBar")
    public void noIncrementProgressBar() throws OutOfRangeException, ElementNotFound {
        LOGGER.info("Starting decrementProgressBar");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        ProgressBarPage progressBarPage = (ProgressBarPage) viewPage.selectView(EViews.PROGRESS_BAR);

        IncrementalBarPage incrementalBarPage = (IncrementalBarPage) progressBarPage
                .selectProgressOption("1. Incremental");

        incrementalBarPage.decreaseMainBar(0);

    }
    @Test(groups = "incrementalProgressBar")
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

    @Test(groups = "incrementalProgressBar")
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


    @Test(groups = {"dialogProgressBar", "regression", "smoke"})
    public void checkDialogLoadingMessage() throws ElementNotFound {
        LOGGER.info("Starting checkDialogLoadingMessage");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        ProgressBarPage progressBarPage = (ProgressBarPage) viewPage.selectView(EViews.PROGRESS_BAR);

        DialogsPage dialogsPage = (DialogsPage) progressBarPage
                .selectProgressOption("3. Dialogs");


        dialogsPage.loadingScreen();
        Assert.assertEquals(dialogsPage.dialogLoadingText(), "Please wait while loading...");
    }

    @Test(groups = {"dialogProgressBar", "smoke"}, expectedExceptions = org.openqa.selenium.NoAlertPresentException.class)
    public void dialogMessageWithOutCorrectScreen() throws ElementNotFound {
        LOGGER.info("Starting checkDialogLoadingMessage");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        ProgressBarPage progressBarPage = (ProgressBarPage) viewPage.selectView(EViews.PROGRESS_BAR);

        DialogsPage dialogsPage = (DialogsPage) progressBarPage
                .selectProgressOption("3. Dialogs");


        Assert.assertEquals(dialogsPage.dialogLoadingText(), "Please wait while loading...");
    }

    @Test(groups = "dialogProgressBar")
    public void returnToMainScreen() throws ElementNotFound {
        LOGGER.info("Starting checkDialogLoadingMessage");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        ProgressBarPage progressBarPage = (ProgressBarPage) viewPage.selectView(EViews.PROGRESS_BAR);

        DialogsPage dialogsPage = (DialogsPage) progressBarPage
                .selectProgressOption("3. Dialogs");


        dialogsPage.loadingScreen();
        Assert.assertEquals(dialogsPage.dialogLoadingText(), "Please wait while loading...");


        dialogsPage.goToMainScreen();

        Assert.assertEquals(dialogsPage.pageTitle(), "Views/Progress Bar/3. Dialogs");
    }
}
