package org.example.intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeWorkXpathGlovo {
    WebDriver driver;
    static Faker faker = new Faker();
    public static String generateFakeName(){
        return faker.name().firstName();
    }
    public static String generateFakeEmail(){
        return faker.internet().emailAddress();
    }
    public static String generateFakePassword(){
        return faker.internet().password();
    }
    public static String generateFakeAddress(){
        return faker.address().fullAddress();
    }

    static String fakeName = generateFakeName();
    static String fakeEmail = generateFakeEmail();
    static String fakePassword = generateFakePassword();
    static String fakeAddress = generateFakeAddress();


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://glovoapp.com/");
    }

    @Test(priority = 1)
    public void test1(){
        WebElement getStartedBtn = driver.findElement(By.xpath("(//button[@id='user-register'])[2]"));
        getStartedBtn.click();
        WebElement firstNameInputField = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[2]"));
        firstNameInputField.sendKeys(fakeName);
        Assert.assertEquals(firstNameInputField.getAttribute("value"), fakeName);
    }

    @Test(priority = 2)
    public void test2(){
        WebElement eMailInputField = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[3]"));
        eMailInputField.sendKeys(fakeEmail);
        Assert.assertEquals(eMailInputField.getAttribute("value"), fakeEmail);
    }

    @Test(priority = 3)
    public void test3(){
        WebElement passwordInputField = driver.findElement(By.xpath("(//input[@class='el-input__inner'])[4]"));
        WebElement seePasswordButton = driver.findElement(By.xpath("//img[@class='text-field__additional-button']"));
        seePasswordButton.click();
        passwordInputField.sendKeys(fakePassword);
        Assert.assertEquals(passwordInputField.getAttribute("value"), fakePassword);
    }

    @Test(priority = 4)
    public void test4() throws InterruptedException {
        WebElement signUpBtn = driver.findElement(By.xpath("//button[@id='signup-button']"));
        signUpBtn.click();
        WebElement addressBtn= driver.findElement(By.xpath("(//div[@class='current-location__text'])[2]"));
        addressBtn.click();
    }





}