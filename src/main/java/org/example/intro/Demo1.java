package org.example.intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo1 {


    @Test
    public void testDemo1(){

        WebDriverManager.chromedriver().setup(); // Configure  ChromeDriver to connect browser

        WebDriver driver = new ChromeDriver(); // Creating instance of driver
        driver.manage().window().maximize(); // Maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //Driver will wait 20 sec

        driver.get("https://demoqa.com/text-box");
        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys("Azat");

        WebElement eMailInputField = driver.findElement(By.id("userEmail"));
        eMailInputField.sendKeys("azatkarapashov@gmail.com");

        WebElement currentAddressInputField = driver.findElement(By.id("currentAddress"));
        currentAddressInputField.sendKeys("Address 123");

        WebElement permanentAddressInputField = driver.findElement(By.id("permanentAddress"));
        permanentAddressInputField.sendKeys("Second address 321");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();


    }
}
