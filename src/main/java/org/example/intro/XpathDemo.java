package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class XpathDemo extends BaseTest {


    @Test
    public void xpathTest() {
        driver.get("https://demoqa.com/text-box");
        WebElement nameText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/label"));
        String expectedEmailText = "Email";
        Assert.assertEquals(nameText.getText(), expectedEmailText);
        WebElement nameText2 = driver.findElement(By.xpath("//label[@id='userEmail-label']"));
        Assert.assertTrue(expectedEmailText.contains(nameText2.getText()));

    }

    @Test
    public void xpathTest2() {
        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        userName.sendKeys("Test123");
        System.out.println("Result is : " + userName.getAttribute("value"));
        Assert.assertEquals(userName.getAttribute("value"), "Test123");

    }

}
