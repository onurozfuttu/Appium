package com.mobile.utilities;

public enum App {

    CALCULATOR("com.google.android.calculator",
            "com.android.calculator2.Calculator"),
    CALENDER("com.google.android.calendar",
            "com.google.android.calendar.launch.oobe.WhatsNewFullScreen");
    public String appPackage;
    public String appActivity;

    App(String appPackage, String appActivity) {
        this.appPackage = appPackage;
        this.appActivity = appActivity;
    }
}

/*
C:\Users\tosun>adb shell
generic_x86_arm:/ $ dumpsys window | grep -E mCurrentFocus
  mCurrentFocus=Window{897831a u0 com.google.android.calculator/com.android.calculator2.Calculator}
  mCurrentFocus=Window{f6ddb97 u0 com.google.android.calendar/com.google.android.calendar.launch.oobe.WhatsNewFullScreen}
 */

