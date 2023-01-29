package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits extends BaseTest{

    @Test
    public void testExplicitWait(){
        driver.navigate().to("https://demoqa.com/dynamic-properties");
        WebElement enableAfter = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter)).click();

        WebElement colorChange = driver.findElement(By.id("colorChange"));
        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"),
                "class", "mt-4 text-danger btn btn-primary"));
        colorChange.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter"))).click();

    }

    @Test
    public void etsySignIn(){
        driver.navigate().to("https://www.etsy.com/");
        WebElement singInBtn = driver.findElement(By.xpath("//button[contains(text(),'Войти')]"));
        singInBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Войти в аккаунт')]")));
    }
}
