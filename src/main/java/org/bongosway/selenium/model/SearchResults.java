package org.bongosway.selenium.model;

import java.util.List;

public class SearchResults {

  List<Result> resultList;

  public SearchResults(List<Result> resultList) {
    this.resultList = resultList;
  }

  public Result get(int index) {
    return resultList.get(index);
  }

  public boolean isGreaterThan(int desiredSize) {
    return resultList.size() > desiredSize;
  }

  @Override
  public String toString() {
    return "SearchResults{" + "resultList=" + resultList + '}';
  }
}
