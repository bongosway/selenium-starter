package org.bongosway.selenium.helper;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ElementInteractionHelper {

  private static WebDriver driver;

  private ElementInteractionHelper() {
  }

  private static WebElement find(By locator) {
    return await(locator);
  }

  private static List<WebElement> findAll(By locator) {
    return awaitAll(locator);
  }

  public static void setDriver(WebDriver driver) {
    ElementInteractionHelper.driver = driver;
  }

  public static void enterText(By by, String text) {
    find(by).clear();
    find(by).sendKeys(text);
  }

  public static void click(By by) {
    find(by).click();
  }

  public static WebElement getElement(By locator) {
    return find(locator);
  }

  public static List<WebElement> getElementList(By by) {
    return findAll(by);
  }

  private static WebElement await(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
    return wait
        .withMessage("****Element: " + locator.toString() + " not found on page****")
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  private static List<WebElement> awaitAll(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
    return wait
        .withMessage("****Element: " + locator.toString() + " not found on page****")
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
  }
}
