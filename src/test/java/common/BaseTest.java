package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    private static ThreadLocal<ExtentReports> extentReports = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        // Initialize browser-specific ExtentReports
        String reportFileName = "ExtentReport_" + browser + ".html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFileName);
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        extentReports.set(reports);

        // Browser setup
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");
    }

    public void setExtentTest(String testName, String description) {
        extentTest.set(extentReports.get().createTest(testName, description));
    }

    public ExtentTest getExtentTest() {
        return extentTest.get();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extentReports.get().flush();
    }
}
