package org.bongosway.selenium.model;

public interface SearchEngine {
  SearchResults searchFor(final String term);
  void openHomePage();
  void openSearchPage();
}
