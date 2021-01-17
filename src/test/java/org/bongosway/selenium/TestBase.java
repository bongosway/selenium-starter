package org.bongosway.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import org.bongosway.selenium.helper.ElementInteractionHelper;
import org.bongosway.selenium.helper.NavigationHelper;
import org.bongosway.selenium.helper.ScreenshotHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Base class for TestNG-based test classes
 */

public class TestBase {

  protected WebDriver driver;
  private static final Map<String, Object> sessionContext = new HashMap<>();

  @BeforeClass
  public void init() {
    sessionContext.clear();
    driver = createChromeDriver();
    ElementInteractionHelper.setDriver(driver);
    NavigationHelper.setDriver(driver);
  }

  @BeforeMethod
  public void setup(Method method) {
    if (driver == null) {
      init();
    }
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) {
    if (!result.isSuccess()) {
      Reporter.log("PageUrl: " + driver.getCurrentUrl(), true);
      Reporter.log(sessionContext.toString(), true);
      ScreenshotHelper.takeScreenShot(driver, generateFileName(result), "screenshots/");
      driver.close();
      driver = null;
    }
  }

  private WebDriver createChromeDriver() {
    WebDriverManager.chromedriver().setup();
    String chromeDriverPath = WebDriverManager.chromedriver().getDownloadedDriverPath();
    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    sessionContext.putIfAbsent("ChromeDriver path: ", chromeDriverPath);

    return new ChromeDriver();
  }

  private String generateFileName(ITestResult result) {
    String description = result.getMethod().getDescription();

    if (!description.isEmpty()) {
      return convertToFilename(description);
    } else {
      return convertToFilename(result.getName());
    }
  }

  private String convertToFilename(String strValue) {
    return strValue.toLowerCase()
        .replaceAll(" ", "_") + "-"
        + LocalTime.now().getNano() + ".png";
  }

  @AfterClass
  public void killSession() {
    if (driver != null) {
      Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
    }
  }
}
