package org.mja123.appiumPractice.android.externalApp;

import org.mja123.appiumPractice.BaseTest;
import org.mja123.appiumPractice.android.ApiDemo.homepage.EHomeOptions;
import org.mja123.appiumPractice.android.ApiDemo.homepage.HomePage;
import org.mja123.appiumPractice.android.ApiDemo.view.DragAndDropPage;
import org.mja123.appiumPractice.android.ApiDemo.view.EViews;
import org.mja123.appiumPractice.android.ApiDemo.view.ViewPage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {
    @Test(groups = {"regression"})
    public void dragAndDropValidDots() throws ElementNotFound {

        LOGGER.info("Starting dragAndDropValidDots");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectView(EHomeOptions.VIEW);

        DragAndDropPage dragAndDropPage = (DragAndDropPage) viewPage.selectView(EViews.DRAG_DROP);

        dragAndDropPage.dragAndDropDot(0, 1);

    }

    @Test(expectedExceptions = ElementNotFound.class,
            groups = {"smoke"})
    public void dragAndDropInvalidDot() throws ElementNotFound {
        LOGGER.info("Starting dragAndDropInvalidDot");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectView(EHomeOptions.VIEW);

        DragAndDropPage dragAndDropPage = (DragAndDropPage) viewPage.selectView(EViews.DRAG_DROP);

        dragAndDropPage.dragAndDropDot(4, -3);
    }

    @Test(groups = {"smoke"})
    public void checkEmptyResultText() throws ElementNotFound {
        LOGGER.info("Starting checkEmptyResultText");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectView(EHomeOptions.VIEW);

        DragAndDropPage dragAndDropPage = (DragAndDropPage) viewPage.selectView(EViews.DRAG_DROP);

        Assert.assertEquals(dragAndDropPage.displayResultText(), "");
    }

    @Test(groups = {"regression"})
    public void checkResultText() throws ElementNotFound {
        LOGGER.info("Starting checkResultText");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectView(EHomeOptions.VIEW);

        DragAndDropPage dragAndDropPage = (DragAndDropPage) viewPage.selectView(EViews.DRAG_DROP);

        dragAndDropPage.dragAndDropDot(2, 1);

        Assert.assertEquals(dragAndDropPage.displayResultText(), "Dropped!");
    }
}
