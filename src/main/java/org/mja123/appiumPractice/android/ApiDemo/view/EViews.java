package org.mja123.appiumPractice.android.ApiDemo.view;

public enum EViews {
    DRAG_DROP("Drag and Drop"),
    WEB_VIEW("WebView"),
    FAKE_ELEMENT("fake element"),
    PROGRESS_BAR("Progress Bar");

    private final String value;

    EViews(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
