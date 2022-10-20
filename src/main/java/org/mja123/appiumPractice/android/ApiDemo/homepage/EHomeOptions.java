package org.mja123.appiumPractice.android.ApiDemo.homepage;

public enum EHomeOptions {
    VIEW("Views");

    private final String text;
    EHomeOptions(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
