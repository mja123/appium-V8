package org.mja123.appiumPractice.builtIn.clockApp.component;

public enum EHeaderOptions {
    ALARM("Alarm"),
    CLOCK("Clock"),
    TIMER("Timer"),
    STOPWATCH("Stopwatch");

    private final String VALUE;

    EHeaderOptions(String VALUE) {
        this.VALUE = VALUE;
    }

    public String getVALUE() {
        return VALUE;
    }
}
