package org.bongosway.selenium.helper;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

  private static WebDriver driver;

  private NavigationHelper() {
  }

  public static void setDriver(WebDriver driver) {
    NavigationHelper.driver = driver;
  }

  public static void open(String url) {
    driver.get(url);
  }

  public static void openWithCookie(String url, Cookie cookie) {
    driver.get(url);
    driver.manage().addCookie(cookie);
    driver.navigate().refresh();
  }
}
