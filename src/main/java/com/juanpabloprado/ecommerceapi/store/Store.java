package com.juanpabloprado.ecommerceapi.store;

import com.juanpabloprado.ecommerceapi.core.BaseEntity;
import com.juanpabloprado.ecommerceapi.product.Product;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Store extends BaseEntity {
  private String name;

  @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
  private Set<Product> products;

  public Store() {
    super();
    products = new HashSet<>();
  }

  public Set<Product> getProducts() {
    return products;
  }

  public void addProduct(Product product) {
    product.setStore(this);
    products.add(product);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
