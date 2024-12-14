//package common;
//
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class New_Version {
//	public static WebDriver driver;
//
//	@BeforeClass
//	public void setUp() {
//		String browser = "chrome";
//
//		if (browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (browser.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new EdgeDriver();
//		}
//
//		driver.get("http://practice.automationtesting.in/");
//		driver.manage().window().maximize();
//		System.out.println("Browser Launched Successfully");
//	}
//
//	@Test(priority = 0)
//	public void Test() {
//
//		// This test is already handled in setUp method
//	}
//
//	// Main list
//	@Test(priority = 1, enabled = true)
//	public void menus() {
//		List<WebElement> menulist = driver.findElements(By.xpath("//*[contains(@id,'menu-item')]/a"));
//		for (WebElement menus : menulist) {
//			System.out.println(menus.getText());
//		}
//	}
//
//	@Test(priority = 2, enabled = true)
//	public void arraymenus() {
//		System.out.println("Started testcase-2");
//
//		// Array of expected titles for each page
//		String[] expectedTitles = { "Shop", "My Account", "Test Cases", "AT Site", "Demo Site" };
//		// Verify each menu item title
//		List<WebElement> menulist = driver.findElements(By.xpath("//*[contains(@id,'menu-item')]/a"));
//		for (int i = 0; i < expectedTitles.length; i++) {
//			// Ensure the list is long enough
//			Assert.assertTrue(i < menulist.size(), "Expected menu item index out of bounds: " + i);
//			// Get the actual title from the web element
//			String actualTitle = menulist.get(i).getText();
//			System.out.println(actualTitle); // Print the actual title for debugging
//			Assert.assertEquals(actualTitle, expectedTitles[i], "Title mismatch for page " + i);
//		}
//	}
//
//	// 3. Set: Ensuring Unique Data (e.g., Unique Links, Tags)
//	@Test(priority = 3, enabled = true)
//	public void Setmenus() {
//		System.out.println("Started testcase-3");
//
////New changes
//		// Retrieve all hyperlinks on the page
//		List<WebElement> links = driver.findElements(By.xpath("//*[contains(@id,'menu-item')]/a"));
//
//		// Correctly instantiate HashSet with generic type
//		Set<String> uniqueLinks = new HashSet<>();
//		System.out.println("uniqueLinks: " + uniqueLinks);
//
//		// Add each link's href attribute to the HashSet
//		for (WebElement link : links) {
//
//			System.out.println(link.getAttribute("href"));
//			uniqueLinks.add(link.getAttribute("href"));
//		}
//
//		// Verify all links are unique by checking the set size
//		Assert.assertEquals(uniqueLinks.size(), links.size(), "There are duplicate links on the page.");
//		System.out.println("uniqueLinks SIze: " + uniqueLinks.size());
//
//	}
//
//	@Test(priority = 4, enabled = true)
//	public void mapmenus() {
//	    // Navigate to My Account
//	    driver.findElement(By.xpath("//a[text()='My Account']")).click();
//
//	    // Map for storing element locators
//	    Map<String, By> elementLocators = new HashMap<>();
//	    elementLocators.put("username", By.id("username"));
//	    elementLocators.put("password", By.id("password"));
//	    elementLocators.put("loginButton", By.cssSelector("input[name='login']"));
//	    elementLocators.put("loginsuccess", By.xpath("//div[@id='page-36']/div/div/div/p[1]/strong"));
//
//	    // Access elements via the map
//	    driver.findElement(elementLocators.get("username")).sendKeys("maskaniraviteja1997");
//	    driver.findElement(elementLocators.get("password")).sendKeys("Ravi@1413");
//	    driver.findElement(elementLocators.get("loginButton")).click();
//
//	    // Wait for the success message to be visible (consider using WebDriverWait for better practice)
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocators.get("loginsuccess")));
//
//	    // Retrieve and print the login success message
//	    String loginSuccessMessage = driver.findElement(elementLocators.get("loginsuccess")).getText();
//	    System.out.println("Login Success Message: " + loginSuccessMessage);
//
//	    // Optionally assert the success message
//	    Assert.assertTrue(loginSuccessMessage.contains("maskaniraviteja1997"), "Login was not successful or the message is incorrect.");
//	}
//
//
//	
//	
//	@Test(priority = 5, enabled = true)
//    public void extractAccountDashboardText() {
//        // Locate the main text container or relevant elements
//        List<WebElement> accountDashboardElements = driver.findElements(By.xpath("//*[contains(text(),'Orders') or contains(text(),'Downloads') or contains(text(),'Addresses') or contains(text(),'Account Details') or contains(text(),'Logout') or contains(text(),'Hello')]"));
//
//        // Extract and print the text from each element
//        StringBuilder fullText = new StringBuilder();
//        for (WebElement element : accountDashboardElements) {
//            fullText.append(element.getText()).append("\n"); // Append each line of text
//        }
//        System.out.println(fullText);
//	}
////	@AfterClass
////	public void tearDown() {
////		if (driver != null) {
////			driver.quit();
////		}
////	}
//}
