package com.mobile.utilities;

public enum Device {
    /**
     * {
     *   "appium:udid": "emulator-5554",
     *   "appium:version": "11",
     *   "appium:deviceName": "Pixel 2",
     *   "appium:realDevice": "false",
     *   "platformName": "Android",
     *   "appium:automationName": "uiautomator2"
     * }
     */

    PIXEL2( "emulator-5554",
            "11",
            "Pixel 2",
            "Android",
            "uiautomator2"

    );
    public String udid;
    public String version;
    public String deviceName;
    public String platformname;
    public String automationName;

    Device(String udid, String version, String deviceName, String platformname, String automationName) {
        this.udid=udid;
        this.version=version;
        this.deviceName=deviceName;
        this.platformname=platformname;
        this.automationName=automationName;
    }
}
