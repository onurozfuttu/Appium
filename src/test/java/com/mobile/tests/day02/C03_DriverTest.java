package com.mobile.tests.day02;

import com.mobile.utilities.App;
import com.mobile.utilities.Device;
import com.mobile.utilities.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class C03_DriverTest {

    //locator set
    By locatorDigit1 = By.id("com.google.android.calculator:id/digit_1");
    By locatorDigit2 = By.id("com.google.android.calculator:id/digit_2");
    By locatorDigit3 = By.id("com.google.android.calculator:id/digit_3");
    By locatorDigit4 = By.id("com.google.android.calculator:id/digit_4");
    By locatorDigit5 = By.id("com.google.android.calculator:id/digit_5");
    By locatorDigit6 = By.id("com.google.android.calculator:id/digit_6");
    By locatorDigit7 = By.id("com.google.android.calculator:id/digit_7");
    By locatorDigit8 = By.id("com.google.android.calculator:id/digit_8");
    By locatorDigit9 = By.id("com.google.android.calculator:id/digit_9");
    By locatorPlus = By.id("com.google.android.calculator:id/op_add");
    By locatorEqual = By.id("com.google.android.calculator:id/eq");
    By locatorResult = By.id("com.google.android.calculator:id/result_final");

    AppiumDriver<MobileElement> driver;

    @Before
    public void setUp(){
        Driver.runAppium();
        driver=Driver.getDriver(Device.PIXEL2, App.CALCULATOR);
    }

    @After
    public void tearDown(){
        driver.closeApp();
        Driver.stopAppium();
    }

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        //Driver.runAppium();
        //driver=Driver.getDriver(Device.PIXEL2, App.CALCULATOR);

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
        //driver.closeApp();

        //Driver.stopAppium();
    }

    @Test
    public void test2(){
        click(locatorDigit2);
        click(locatorPlus);
        click(locatorDigit3);
        click(locatorEqual);

        Assert.assertEquals("5",getText(locatorResult));
    }

    void click(By locator){
        Driver.getDriver().findElement(locator).click();
    }

    String getText(By locator){
        return Driver.getDriver().findElement(locator).getText();
    }
}
