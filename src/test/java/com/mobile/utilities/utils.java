package com.mobile.utilities;

import io.appium.java_client.AppiumDriver;

public class utils {
    public static AppiumDriver<?> openApp(Device device, App app){
        Driver.runAppium();
        return Driver.getDriver(device, app);
    }
}
