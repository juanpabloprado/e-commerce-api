package com.juanpabloprado.ecommerceapi.product;

import com.juanpabloprado.ecommerceapi.integration.agenty.dto.Result;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  @Override public Product fromIntegration(Result result) {
    try {
      Number number = NumberFormat.getCurrencyInstance(new Locale("es", "MX")).parse(result.getPrice());
      BigDecimal price = new BigDecimal(number.doubleValue());

      return new Product(result.getName(), price, null, result.getImageUrl());
    } catch (Exception ex ) {
      return new Product(result.getName(), new BigDecimal("0.00"), result.getPrice(), result.getImageUrl());
    }

  }
}
