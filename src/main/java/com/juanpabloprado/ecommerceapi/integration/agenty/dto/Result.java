package com.juanpabloprado.ecommerceapi.integration.agenty.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
  private String name;
  private String price;
  private String imageUrl;

  public Result() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override public String toString() {
    return "Result{" +
        "name='" + name + '\'' +
        ", price='" + price + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        '}';
  }
}
