package org.bongosway.selenium.pages.google;

import static org.bongosway.selenium.helper.ElementInteractionHelper.enterText;
import static org.bongosway.selenium.helper.ElementInteractionHelper.getElement;

import org.openqa.selenium.By;

public class SearchForm {

  private static final By searchFormAutocomplete = By.cssSelector("#searchform ul>li");
  private static final By inputField = By.name("q");

  public SearchForm search(String term) {
    enterText(inputField, term);
    getElement(searchFormAutocomplete).click();
    return this;
  }
}
