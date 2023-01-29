package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Frames extends BaseTest{

    @Test
    public void test(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame(2);
        WebElement text = driver.findElement(By.id("sampleHeading"));
        System.out.println(text.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(3);
        WebElement text2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(text2.getText());
        driver.switchTo().defaultContent();
        WebElement text3 = driver.findElement(By.xpath("//div[@class='main-header']"));
        System.out.println(text3.getText());
    }

    @Test
    public void test2(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame(2); // переключение с помощью индекса
        driver.switchTo().frame("frame1"); // переключение с помощью ID
        driver.switchTo().frame(driver.findElement(By.id("frame1"))); // переключение с помощью WebElement
        driver.switchTo().defaultContent();// возврат на главный HTML

    }
}
