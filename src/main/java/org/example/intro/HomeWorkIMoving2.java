package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkIMoving2 extends BaseTest {

    public static void clicksElement(WebElement element, int click) {
        for (int i = 0; i < click; i++) {
            element.click();
        }
    }

    @Test(priority = 1)
    public void test1() {
        driver.get("https://www.imoving.com");

        WebElement houseTypeSelectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(houseTypeSelectMenu);
        WebElement selectMyApartment = driver.findElement(By.xpath("//option[@value='1079']"));
        select.selectByValue("1079");
        Assert.assertTrue(selectMyApartment.isSelected());
    }

    @Test(priority = 2)
    public void test2() {
        WebElement moveSizeSelectMenu = driver.findElement(By.id("hp-nav-select-house"));
        Select select2 = new Select(moveSizeSelectMenu);
        WebElement selectJustAFewItems = driver.findElement(By.xpath("//option[@value='9509']"));
        select2.selectByValue("9509");
        Assert.assertTrue(selectJustAFewItems.isSelected());

    }

    @Test(priority = 3)
    public void test3() {
        WebElement compareQuotesBtn = driver.findElement(By.xpath("//button[@class='btn btn-white quickQuoteLink']"));
        compareQuotesBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/full-inventory/#!/");
    }

    @Test(priority = 4)
    public void test4() {
        driver.findElement(By.xpath("//a[@class='btn btn-blue col-xs-6']")).click();
        Helper.pause(2000);
        driver.findElement(By.xpath("(//a[@class='btn btn-blue'])[1]")).click();
        driver.findElement(By.xpath("//a[@id='closeTutorial']")).click();
    }

    @Test(priority = 5)
    public void test5() {
        Actions actions = new Actions(driver);
        WebElement dresserIcon = driver.findElement(By.xpath("//div[@style='z-index: 15']"));
        actions.moveToElement(dresserIcon).perform();
        driver.findElement(By.xpath("//div[@class='14']/descendant::a[contains(text(),'Add to Inventory')]")).click();
        driver.findElement(By.xpath("(//div[@class='14']/descendant::button[@class='quantity-plus'])[1]")).click();

        WebElement bedIcon = driver.findElement(By.xpath("//div[@class='13']/descendant::div[@class='item']"));
        actions.moveToElement(bedIcon).perform();
        driver.findElement(By.xpath("//div[@class='13']/descendant::a[contains(text(),'Add to Inventory')]")).click();
        WebElement bedPlusBtn = driver.findElement(By.xpath("(//div[@class='13']/descendant::button[@class='quantity-plus'])[1]"));
        clicksElement(bedPlusBtn, 1);

        WebElement tvIcon = driver.findElement(By.xpath("//div[@class='12']/descendant::div[@class='item']"));
        actions.moveToElement(tvIcon).perform();
        driver.findElement(By.xpath("//div[@class='12']/descendant::a[contains(text(),'Add to Inventory')]")).click();
        WebElement TvPlusBtn = driver.findElement(By.xpath("(//div[@class='12']/descendant::button[@class='quantity-plus'])[1]"));
        clicksElement(TvPlusBtn, 2);

        int dresserAmount = Integer.parseInt(driver.findElement(By.xpath("(//div[@class='14']/descendant::input)[1]")).getAttribute("value"));
        int bedAmount = Integer.parseInt(driver.findElement(By.xpath("(//div[@class='13']/descendant::input)[1]")).getAttribute("value"));
        int tvAmount = Integer.parseInt(driver.findElement(By.xpath("(//div[@class='12']/descendant::input)[1]")).getAttribute("value"));
        int sumItem = dresserAmount + bedAmount + tvAmount;

        String amountItemsValue = driver.findElement(By.xpath("(//span[@class='room-counter'])[1]")).getText();
        int amountItems = Integer.parseInt(amountItemsValue.substring(0, amountItemsValue.indexOf(" ")));

        Assert.assertEquals(amountItems, sumItem);
    }

    @Test(priority = 6)
    public void test6() {
        driver.findElement(By.xpath("(//a[@class='action-box'])[2]")).click();
        WebElement smallBox = driver.findElement(By.xpath("(//div[@class='quantity-module']/descendant::button[@class='quantity-plus'])[1]"));
        clicksElement(smallBox, 2);

        WebElement largeBox = smallBox.findElement(By.xpath("(//div[@class='quantity-module']/descendant::button[@class='quantity-plus'])[3]"));
        clicksElement(largeBox, 1);

        WebElement wardrobeBox = smallBox.findElement(By.xpath("(//div[@class='quantity-module']/descendant::button[@class='quantity-plus'])[6]"));
        clicksElement(largeBox, 3);

        driver.findElement(By.xpath("//a[text()='Add and Continue']")).click();
        Helper.pause(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/full-inventory/#!/moving-details");
    }

    @Test(priority = 7)
    public void test7() {
        WebElement addressInputField = driver.findElement(By.xpath("(//input[@ng-focus='vmInputAutoComplete.geolocate()'])[1]"));
        addressInputField.sendKeys("6000 North Terminal Parkway, Atlanta, GA 30320, USA");
        driver.findElement(By.xpath("(//button[@class='btn btn-green save-instructions'])[1]")).click();

        WebElement addressInputField2 = driver.findElement(By.xpath("(//input[@ng-focus='vmInputAutoComplete.geolocate()'])[2]"));
        addressInputField2.sendKeys("41580 Sunday Morning Lane, Leesburg, VA 20176, USA");

        driver.findElement(By.xpath("(//button[@class='btn btn-green save-instructions'])[3]")).click();

        driver.findElement(By.xpath("//button[@class='btn btn-blue confirm']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-green']")).click();
        Helper.pause(3000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/full-inventory/#!/moving-results");

    }

}
