import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoTests {

    WebDriver driver;

    //TC1 valid log and pass
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void loginSuccessTest(){

        driver.get("http://testing-ground.scraping.pro/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("usr")).sendKeys("admin");
        driver.findElement(By.id("pwd")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h3[@class='success']")).isDisplayed());

    }

    //TC2 vrong log and pass
    @Test
    public void loginNoExistingUser(){
        driver.get("http://testing-ground.scraping.pro/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("usr")).sendKeys("qwer");
        driver.findElement(By.id("pwd")).sendKeys("qwer");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h3[@class='error']")).isDisplayed());
    }

}
