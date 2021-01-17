package org.bongosway.selenium.helper;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public final class ScreenshotHelper {

  private ScreenshotHelper() {
  }

  public static void takeScreenShot(WebDriver driver, String filename, String destinationPath) {
    try {
      File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File screenshotFile = new File(destinationPath + filename);

      if (!screenshotFile.exists()) {
        FileUtils.copyFile(scrFile, screenshotFile);
        Reporter.log("Screenshot saved to: " + screenshotFile.getAbsolutePath(), true);
      }
    } catch (Exception e) {
      Reporter.log("Error trying to take screen shot: " + e.getMessage());
    }
  }

}
