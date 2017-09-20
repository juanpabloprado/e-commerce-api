package com.juanpabloprado.ecommerceapi.integration.agenty;

import com.juanpabloprado.ecommerceapi.integration.agenty.dto.Agent;
import com.juanpabloprado.ecommerceapi.integration.agenty.dto.Result;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AgentyClient {

  private final RestTemplate restTemplate;

  public AgentyClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.additionalCustomizers(rt ->
        rt.getInterceptors().add(new HeaderRequestInterceptor())).build();
  }

  public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws
        IOException {
      request.getHeaders().set("X-DataScraping-Api-Key", "957e36bb0682dc2c694d7f2135e7fcdf");
      request.getHeaders().set("X-DataScraping-Api-Id", "07O6EDABBL");
      return execution.execute(request, body);
    }
  }

  public List<Result> getRecentResults() {
    ResponseEntity<Agent> response = invoke(createRequestEntity("https://api.agenty.com/v1/output/e01f679a82?offset=0&limit=1000"), Agent.class);
    return Arrays.asList(response.getBody().getResult());
  }

  private <T> ResponseEntity<T> invoke(RequestEntity<?> request, Class<T> type) {
    return this.restTemplate.exchange(request, type);
  }

  private RequestEntity<?> createRequestEntity(String url) {
    try {
      return RequestEntity.get(new URI(url))
          .accept(MediaType.APPLICATION_JSON).build();
    }
    catch (URISyntaxException ex) {
      throw new IllegalStateException("Invalid URL " + url, ex);
    }
  }
}
