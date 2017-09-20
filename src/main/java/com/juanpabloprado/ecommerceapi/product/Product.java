package com.juanpabloprado.ecommerceapi.product;

import com.google.common.base.Objects;
import com.juanpabloprado.ecommerceapi.core.BaseEntity;
import com.juanpabloprado.ecommerceapi.store.Store;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product extends BaseEntity {
  @NotNull
  @Size(min = 2, max = 140)
  private String name;
  private BigDecimal price;
  private String description;
  private String imageUrl;

  @ManyToOne
  private Store store;

  public Product() {
    super();
  }

  public Product(String name, BigDecimal price, String description, String imageUrl) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.imageUrl = imageUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Product)) return false;
    Product product = (Product) o;
    return Objects.equal(name, product.name) &&
        Objects.equal(price, product.price) &&
        Objects.equal(description, product.description) &&
        Objects.equal(store, product.store);
  }

  @Override public int hashCode() {
    return Objects.hashCode(name, price, description, store);
  }
}
