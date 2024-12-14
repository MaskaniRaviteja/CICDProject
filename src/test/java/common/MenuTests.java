package common;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class MenuTests extends BaseTest {

    @Test(priority = 1)
    public void verifyMenuItems() {
        setExtentTest("Verify Menu Items", "Validate all menu items are displayed correctly");
        List<WebElement> menuList = driver.findElements(By.xpath("//*[contains(@id,'menu-item')]/a"));

        for (WebElement menu : menuList) {
            System.out.println("Menu Item: " + menu.getText());
            getExtentTest().log(Status.INFO, "Menu Item Found: " + menu.getText());
        }
        Assert.assertTrue(menuList.size() > 0, "No menu items found");
        getExtentTest().pass("Menu items verified successfully");
    }

    @Test(priority = 2)
    public void validateMenuTitles() {
        setExtentTest("Validate Menu Titles", "Compare menu titles with expected titles");
        String[] expectedTitles = {"Shop", "My Account", "Test Cases", "AT Site", "Demo Site"};
        List<WebElement> menuList = driver.findElements(By.xpath("//*[contains(@id,'menu-item')]/a"));

        for (int i = 0; i < expectedTitles.length; i++) {
            Assert.assertTrue(i < menuList.size(), "Expected menu item index out of bounds: " + i);
            String actualTitle = menuList.get(i).getText();
            getExtentTest().log(Status.INFO, "Verifying Title: " + actualTitle);
            Assert.assertEquals(actualTitle, expectedTitles[i], "Title mismatch at index " + i);
        }
        getExtentTest().pass("All menu titles matched expected values");
    }

    @Test(priority = 3)
    public void validateUniqueLinks() {
        setExtentTest("Validate Unique Links", "Ensure all menu links are unique");
        List<WebElement> links = driver.findElements(By.xpath("//*[contains(@id,'menu-item')]/a"));
        Set<String> uniqueLinks = new HashSet<>();

        for (WebElement link : links) {
            uniqueLinks.add(link.getAttribute("href"));
        }

        Assert.assertEquals(uniqueLinks.size(), links.size(), "Duplicate links found");
        getExtentTest().pass("All menu links are unique");
    }

    @Test(priority = 4)
    public void verifyMyAccountPageElements() {
        setExtentTest("Verify My Account Page Elements", "Validate login functionality");
        driver.findElement(By.xpath("//a[text()='My Account']")).click();

        Map<String, By> elementLocators = new HashMap<>();
        elementLocators.put("username", By.id("username"));
        elementLocators.put("password", By.id("password"));
        elementLocators.put("loginButton", By.cssSelector("input[name='login']"));
        elementLocators.put("loginSuccess", By.xpath("//div[@id='page-36']/div/div/div/p[1]/strong"));

        driver.findElement(elementLocators.get("username")).sendKeys("maskaniraviteja1997");
        driver.findElement(elementLocators.get("password")).sendKeys("Ravi@1413");
        driver.findElement(elementLocators.get("loginButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocators.get("loginSuccess")));

        String loginMessage = driver.findElement(elementLocators.get("loginSuccess")).getText();
        Assert.assertTrue(loginMessage.contains("maskaniraviteja1997"), "Login failed");
        getExtentTest().pass("Login successful with username maskaniraviteja1997");
    }

    @Test(priority = 5)
    public void extractDashboardText() {
        setExtentTest("Extract Dashboard Text", "Retrieve account dashboard details");
        List<WebElement> dashboardElements = driver.findElements(By.xpath("//*[contains(text(),'Orders') or contains(text(),'Downloads') or contains(text(),'Addresses') or contains(text(),'Account Details') or contains(text(),'Logout') or contains(text(),'Hello')]"));

        StringBuilder dashboardText = new StringBuilder();
        for (WebElement element : dashboardElements) {
            dashboardText.append(element.getText()).append("\n");
        }
        System.out.println("Dashboard Text:\n" + dashboardText);
        getExtentTest().pass("Dashboard text extracted successfully");
    }
}
