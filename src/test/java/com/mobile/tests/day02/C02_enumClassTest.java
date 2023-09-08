package com.mobile.tests.day02;

import com.mobile.utilities.App;
import com.mobile.utilities.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class C02_enumClassTest {
    AppiumDriver<MobileElement> driver; //before version 8
    AppiumDriverLocalService service;
    Device device = Device.PIXEL2;
    App app = App.CALCULATOR;


    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(1111)
                .usingAnyFreePort()
                .build();

        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);
        capabilities.setCapability("appium:device", device.deviceName);
        capabilities.setCapability("platformName", device.platformname);
        capabilities.setCapability("appPackage", app.appPackage);
        capabilities.setCapability("appActivity", app.appActivity);

        //driver=new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // driver=new AppiumDriver<MobileElement>(service.getUrl(),capabilities);
        // driver=new AppiumDriver<>(service.getUrl(),capabilities);
        driver = new AndroidDriver<>(service.getUrl(), capabilities); //iosDriver. after 8 methods on android and ios drivers.
        MobileElement digit2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement plusBtn = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement digit3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        MobileElement equalBtn = driver.findElement(By.id("com.google.android.calculator:id/eq"));
        digit2.click();
        plusBtn.click();
        digit3.click();
        equalBtn.click();
        MobileElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        String actualResult = result.getText();
        Assert.assertEquals("5", actualResult);

        Thread.sleep(3000);
        driver.closeApp();
        //appium service has been stopped
        service.stop();
    }
}
