package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BrowserDemo  extends BaseTest{


    @Test
    public void test1(){
        browserHelper.openURL("https://demoqa.com/browser-windows");
        WebElement newTabBtn = driver.findElement(By.id("tabButton"));
        newTabBtn.click();
        Helper.pause(3000);
        browserHelper.switchToWindow(0);
        Helper.pause(3000);
        browserHelper.switchToBack();

    }
}
