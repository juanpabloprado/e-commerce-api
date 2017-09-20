package com.juanpabloprado.ecommerceapi.product;

import com.juanpabloprado.ecommerceapi.integration.agenty.dto.Result;

public interface ProductService {
  Product fromIntegration(Result result);
}
