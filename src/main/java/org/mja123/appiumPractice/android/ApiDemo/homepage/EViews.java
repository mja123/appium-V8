package org.mja123.appiumPractice.android.ApiDemo.homepage;

public enum EViews {
    VIEW("Views");

    private final String text;
    EViews(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
