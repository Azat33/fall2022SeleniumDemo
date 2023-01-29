package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWorkAmazonBrandsList extends BaseTest{

    @Test
    public void test(){

        driver.get("https://www.amazon.com");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));

        System.out.println(appleText.getText());

        driver.findElement((By.xpath("//*[@id='brandsRefinements']/ul/li[8]/span/div/a/span"))).click();

        List<WebElement> allBrands = driver.findElements(By.xpath("//li[contains(@id,'p_89/')]"));
        for (WebElement e: allBrands){
            if (e.getText().equals("SAMSUNG")){
                e.findElement(By.tagName("i")).click();
                break;
            }
        }
    }
}
