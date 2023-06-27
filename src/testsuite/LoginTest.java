package testsuite;
/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValidCredentials
 * * Enter “Admin” username
 * * Enter “admin123 password
 * * Click on ‘LOGIN’ button
 * * Verify the ‘Dashboard’ text is display
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find username field and enter username
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        //Click on Login button
        driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
        //Verify the 'Dashboard' text is display
        driver.findElement(By.xpath("//a[@class = 'oxd-main-menu-item active']"));
        //Verify dashboard text is display
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//div[@class = 'oxd-topbar-header-title']")).getText();
        Assert.assertEquals("Dashboard text not displayed", expectedText, actualText);
    }
    @After
    public void tearDown(){
    closeBrowser();
    }
}


