package org.example.intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWorkDemoQaWebTables extends BaseTest{

    Faker faker = new Faker();
    String fakeName = faker.name().firstName();
    String fakeLastName = faker.name().lastName();
    String fakeEmail = faker.internet().emailAddress();
    String fakeAge = String.valueOf(faker.random().nextInt(18, 65));
    String fakeSalary = String.valueOf(faker.random().nextInt(2000, 5000));
    String fakeDepartment = faker.company().profession();

    @Test
    public void test1() {
        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys(fakeName);
        driver.findElement(By.id("lastName")).sendKeys(fakeLastName);
        driver.findElement(By.id("userEmail")).sendKeys(fakeEmail);
        driver.findElement(By.id("age")).sendKeys(fakeAge);
        driver.findElement(By.id("salary")).sendKeys(fakeSalary);
        driver.findElement(By.id("department")).sendKeys(fakeDepartment);
        driver.findElement(By.id("submit")).click();

        WebElement webTable = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        List<WebElement> table = webTable.findElements(By.xpath("//div[@class='rt-tr-group']"));
        int count = 0;
        for (WebElement e : table) {
            count++;
            if (e.getText().contains(fakeName)) {
                System.out.println(count);
                List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])" + "[" + count + "]"));
                for (WebElement b : elements) {
                    Assert.assertTrue(b.getText().contains(fakeName));
                    Assert.assertTrue(b.getText().contains(fakeLastName));
                    Assert.assertTrue(b.getText().contains(fakeEmail));
                    Assert.assertTrue(b.getText().contains(fakeAge));
                    Assert.assertTrue(b.getText().contains(fakeSalary));
                    Assert.assertTrue(b.getText().contains(fakeDepartment));
                    System.out.println(b.getText());
                }
            }
        }
    }
}
