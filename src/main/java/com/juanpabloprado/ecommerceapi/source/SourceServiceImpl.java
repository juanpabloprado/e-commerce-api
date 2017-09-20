package com.juanpabloprado.ecommerceapi.source;

import com.juanpabloprado.ecommerceapi.integration.agenty.AgentyClient;
import com.juanpabloprado.ecommerceapi.integration.agenty.dto.Result;
import com.juanpabloprado.ecommerceapi.product.Product;
import com.juanpabloprado.ecommerceapi.product.ProductService;
import com.juanpabloprado.ecommerceapi.store.Store;
import com.juanpabloprado.ecommerceapi.store.StoreRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SourceServiceImpl implements SourceService {

  private final AgentyClient agentyClient;
  private final StoreRepository storeRepository;
  private final ProductService productService;

  public SourceServiceImpl(
      AgentyClient agentyClient,
      StoreRepository storeRepository,
      ProductService productService) {
    this.agentyClient = agentyClient;
    this.storeRepository = storeRepository;
    this.productService = productService;
  }

  @Override public void fillAllProducts() {
    fillAmazonProducts();
    fillLiverpoolProducts();
    fillLinioProducts();
  }

  @Override public void fillAmazonProducts() {
    Store amazonStore = storeRepository.findOne(1L);

    List<Result> recentResults = agentyClient.getRecentResults(AgentyClient.AMAZON_STORE);
    for (Result recentResult : recentResults) {
      Product product = productService.fromIntegration(recentResult);
      amazonStore.addProduct(product);
    }
    storeRepository.save(amazonStore);
  }

  @Override public void fillLiverpoolProducts() {
    Store liverpoolStore = storeRepository.findOne(2L);

    List<Result> recentResults = agentyClient.getRecentResults(AgentyClient.LIVERPOOL_STORE);
    for (Result recentResult : recentResults) {
      Product product = productService.fromIntegration(recentResult);
      liverpoolStore.addProduct(product);
    }
    storeRepository.save(liverpoolStore);
  }

  @Override public void fillLinioProducts() {
    Store linioStore = storeRepository.findOne(3L);

    List<Result> recentResults = agentyClient.getRecentResults(AgentyClient.LINIO_STORE);
    for (Result recentResult : recentResults) {
      Product product = productService.fromIntegration(recentResult);
      linioStore.addProduct(product);
    }
    storeRepository.save(linioStore);
  }
}
