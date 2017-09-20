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
      String firstPrice = getFirstWord(result.getPrice());
      Number number =
          NumberFormat.getCurrencyInstance(new Locale("es", "MX")).parse(firstPrice);
      BigDecimal price = new BigDecimal(number.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN);;

      return new Product(result.getName(), price, null, result.getImageUrl());
    } catch (Exception ex) {
      return new Product(result.getName(), new BigDecimal("0.00"), result.getPrice(),
          result.getImageUrl());
    }
  }

  private String getFirstWord(String text) {
    if (text.indexOf(' ') > -1) {
      return text.substring(0, text.indexOf(' '));
    } else {
      return text;
    }
  }
}
