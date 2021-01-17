package org.bongosway.selenium.pages.google;

import java.util.List;
import java.util.stream.Collectors;
import org.bongosway.selenium.helper.ElementInteractionHelper;
import org.bongosway.selenium.model.Result;
import org.bongosway.selenium.model.SearchResults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

  private static final By link = By.cssSelector("a");
  private static final By results = By.cssSelector("#search .g");

  public SearchResults collectResults() {
    List<WebElement> elementList = ElementInteractionHelper.getElementList(results);

    List<Result> resultList = elementList.stream()
        .filter(e -> !e.findElement(link).getText().equals(""))
        .limit(15)
        .map(e -> new Result(
            e.findElement(link).getAttribute("href"),
            e.findElement(link).getText())).collect(Collectors.toList());

    return new SearchResults(resultList);
  }
}
