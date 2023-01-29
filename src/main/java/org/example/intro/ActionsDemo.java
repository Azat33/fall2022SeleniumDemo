package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsDemo extends BaseTest{

    @Test
    public void testRadioButton(){
        driver.get("https://demoqa.com/radio-button");
        WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesRadio.click();
        Assert.assertTrue(yesRadio.isEnabled());
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='mt-3']")).getText()
                , "You have selected Yes");
    }

    @Test
    public void testCheckBox(){
        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("(//button[@title='Toggle'])[1]")).click();
        driver.findElement(By.xpath("(//button[@title='Toggle'])[2]")).click();
        WebElement clickCommands = driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[4]"));
        clickCommands.click();
        Assert.assertTrue(clickCommands.isEnabled());
    }
    @Test
    public void testDoubleClick(){
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        Helper.pause(3000);
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText()
                , "You have done a double click");

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();
        Helper.pause(3000);
        Assert.assertEquals(driver.findElement(By.id("rightClickMessage")).getText()
                , "You have done a right click");


        WebElement clickMeBtn = driver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.click(clickMeBtn).perform();
        Helper.pause(3000);
        Assert.assertEquals(driver.findElement(By.id("dynamicClickMessage")).getText()
                , "You have done a dynamic click");
    }



}
