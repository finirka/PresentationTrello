package com.qa.trelloweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testLogin() throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), "puolucca67@gmail.com");
        Thread.sleep(2000);

        click(By.cssSelector("#login"));
        type(By.name("password"), "Matikaynen1967");
        //click(By.cssSelector("#login-submit"));
        click(By.id("login-submit"));
        Thread.sleep(15000);

        //boolean b = wd.findElements(By.cssSelector("[data-test-id='header-home-button']")).size() > 0;
        //boolean b =wd.findElements(By.xpath("span[@aria-label='HouseIcon']")).size()>0;
        //Assert.assertTrue(b);
        Assert.assertTrue(wd.findElements(By.cssSelector("[data-test-id='header-home-button']")).size() > 0);

    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}

