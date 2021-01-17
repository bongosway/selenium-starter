package org.bongosway.selenium.pages.google;

import static org.bongosway.selenium.helper.NavigationHelper.openWithCookie;

import org.bongosway.selenium.model.SearchEngine;
import org.bongosway.selenium.model.SearchResults;
import org.openqa.selenium.Cookie;

public class GoogleSearchEngine implements SearchEngine {
  public static final String SELF_URL = "https://www.google.com";

  @Override
  public void openHomePage() {
    openWithCookie(SELF_URL, consentCookie());
  }

  @Override
  public void openSearchPage() {
    openWithCookie(SELF_URL + "/search?q=''", consentCookie());
  }

  @Override
  public SearchResults searchFor(String term) {
    SearchForm searchForm = new SearchForm();
    searchForm.search(term);

    return new SearchResultPage().collectResults();
  }

  private Cookie consentCookie() {
    return new Cookie("CONSENT", "YES+GB.en-GB+V9+BX",
        ".google.com", "/", null, true);
  }
}
