package org.bongosway.selenium.model;

public class Result {

  private String link;
  private String linkText;

  public Result(String link, String linkText) {
    this.link = link;
    this.linkText = linkText;
  }

  public String getLink() {
    return link;
  }

  public String getLinkText() {
    return linkText;
  }

  @Override
  public String toString() {
    return "Result{" + "link='" + link + '\'' + ", linkText='" + linkText + '\'' + '}';
  }
}
