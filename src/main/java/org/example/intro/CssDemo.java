package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssDemo extends BaseTest {

    @Test
    public void cssTest1() {
        driver.get("https://www.amazon.com");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
//        WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));
//
//        System.out.println(appleText.getText());

//        driver.findElement((By.xpath("//*[@id='brandsRefinements']/ul/li[8]/span/div/a/span"))).click();

//        driver.findElement(By.xpath("//li[@id='p_89/ONEPLUS']/descendant::i")).click();
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands){
            count++;
            if (e.getText().equals("SAMSUNG")){
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']/ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
                break;
            }
        }

    }
}
