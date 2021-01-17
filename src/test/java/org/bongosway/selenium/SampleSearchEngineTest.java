package org.bongosway.selenium;

import static org.testng.Assert.assertTrue;

import org.bongosway.selenium.model.SearchEngine;
import org.bongosway.selenium.model.SearchResults;
import org.bongosway.selenium.pages.google.GoogleSearchEngine;
import org.testng.annotations.Test;

public class SampleSearchEngineTest extends TestBase {

  @Test(description = "User can start search from home page")
  public void start_search_from_google_home_page() {
    SearchEngine searchEngine = new GoogleSearchEngine();

    searchEngine.openHomePage();
    SearchResults searchResults = searchEngine.searchFor("Selenium Java");
    assertTrue(searchResults.isGreaterThan(0), "No result displayed");
  }

  @Test(description = "User can start search from results page")
  public void start_search_from_google_results_page() {
    SearchEngine searchEngine = new GoogleSearchEngine();

    searchEngine.openSearchPage();
    SearchResults searchResults = searchEngine.searchFor("Selenium Java");
    assertTrue(searchResults.isGreaterThan(0), "No result displayed");
  }
}
