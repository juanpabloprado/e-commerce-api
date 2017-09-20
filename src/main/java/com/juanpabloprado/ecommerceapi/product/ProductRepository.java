package com.juanpabloprado.ecommerceapi.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

  @RestResource(rel = "name-contains", path = "containsName")
  Page<Product> findByNameContaining(@Param("name") String name, Pageable page);
}
