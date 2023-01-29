package org.example.intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo extends BaseTest{

    @Test
    public void testAlert1(){
        driver.get("https://demoqa.com/alerts");

        WebElement alertBtn = driver.findElement(By.id("alertButton"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Helper.pause(3000);

    }

    @Test
    public void testExplicitWaitAndAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertBtn = driver.findElement(By.id("timerAlertButton"));
        alertBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void testExplicitWaitAndAlert2(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertBtn = driver.findElement(By.id("timerAlertButton"));
        alertBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();

    }
    @Test
    public void testThirdBtn(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertBtn = driver.findElement(By.id("confirmButton"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("confirmResult")).getText(), "You selected Cancel");

    }
    @Test
    public void testTextEnterAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertBtn = driver.findElement(By.id("promtButton"));
        alertBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Azat");
        alert.accept();
        WebElement textTest = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(textTest.getText(), "You entered Azat");
    }
}
