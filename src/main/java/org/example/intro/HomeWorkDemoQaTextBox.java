package org.example.intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWorkDemoQaTextBox {

    static Faker faker = new Faker();

    public static String generateFakeFullName(){
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String generateFakeEmail(){
        return faker.internet().emailAddress();
    }

    public static String generateFakeAddress(){
        return faker.address().fullAddress();
    }

    public static String generateFakeSecondAddress(){
        return faker.address().secondaryAddress();
    }

    @Test
    public void testDemoQaTextBox(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        String fakeFullName = generateFakeFullName();
        String fakeEmail = generateFakeEmail();
        String fakeAddress = generateFakeAddress();
        String fakeSecondAddress = generateFakeSecondAddress();

        driver.get("https://demoqa.com/text-box");
        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys(fakeFullName);

        WebElement eMailInputField = driver.findElement(By.id("userEmail"));
        eMailInputField.sendKeys(fakeEmail);

        WebElement currentAddressInputField = driver.findElement(By.id("currentAddress"));
        currentAddressInputField.sendKeys(fakeAddress);

        WebElement permanentAddressInputField = driver.findElement(By.id("permanentAddress"));
        permanentAddressInputField.sendKeys(fakeSecondAddress);

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        WebElement name = driver.findElement(By.id("name"));
        WebElement eMail = driver.findElement(By.id("email"));
        WebElement currentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement permanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

        Assert.assertEquals(name.getText(), "Name:" + fakeFullName);
        Assert.assertEquals(eMail.getText(), "Email:" + fakeEmail);
        Assert.assertEquals(currentAddress.getText(), "Current Address :" + fakeAddress);
        Assert.assertEquals(permanentAddress.getText(), "Permananet Address :" + fakeSecondAddress);
    }
}
