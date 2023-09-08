package com.mobile.tests.day02;

import com.mobile.utilities.App;
import com.mobile.utilities.Device;
import com.mobile.utilities.Driver;
import com.mobile.utilities.utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class C04_OpenAppTest {
    // locator set
    String prelocator="com.google.android.calculator:id/";
    By ldigit0=By.id(prelocator + "digit_0");
    By ldigit1=By.id(prelocator + "digit_1");
    By ldigit2=By.id(prelocator + "digit_2");
    By ldigit3=By.id(prelocator + "digit_3");
    By ldigit4=By.id(prelocator + "digit_4");
    By ldigit5=By.id(prelocator + "digit_5");
    By ldigit6=By.id(prelocator + "digit_6");
    By ldigit7=By.id(prelocator + "digit_7");
    By ldigit8=By.id(prelocator + "digit_8");
    By ldigit9=By.id(prelocator + "digit_9");
    By lplusBtn=By.id(prelocator + "op_add");
    By lminusBtn=By.id(prelocator + "op_sub");
    By ldivBtn=By.id(prelocator + "op_div");
    By lmultplyBtn=By.id(prelocator + "op_mul");
    By ldelBtn=By.id(prelocator + "del");
    By lpctBtn=By.id(prelocator + "op_pct");
    By lpointBtn=By.id(prelocator + "dec_point");
    By leqBtn=By.id(prelocator + "eq");
    By lresult=By.id(prelocator + "result_final");


    AppiumDriver<MobileElement> driver;
    WebDriverWait wait;
    @Before
    public void beforeTest(){
        utils.openApp(Device.PIXEL2,App.CALCULATOR);
        wait=new WebDriverWait(driver,10);
    }
    @After
    public void afterTest(){
        driver.quit();
        Driver.stopAppium();
    }

//    @Test
//    public void test1()  {
//        wait.until(ExpectedConditions.elementToBeClickable(ldigit9)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(ldivBtn)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(ldigit3)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(leqBtn)).click();
//        Assert.assertEquals("3",getText(lresult));
//    }

    @Test
    public void test2(){
        click(ldigit2);
        click(lplusBtn);
        click(ldigit4);
        click(leqBtn);
        Assert.assertEquals("6",getText(lresult));

    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void click(MobileElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    String getText(By locator){
        return Driver.getDriver().findElement(locator).getText();
    }
}
