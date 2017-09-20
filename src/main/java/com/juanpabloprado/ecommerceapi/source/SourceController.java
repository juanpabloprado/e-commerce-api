package com.juanpabloprado.ecommerceapi.source;

import com.juanpabloprado.ecommerceapi.integration.agenty.AgentyClient;
import com.juanpabloprado.ecommerceapi.integration.agenty.dto.Result;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SourceController {

  private final AgentyClient agentyClient;
  private static final Logger log = LoggerFactory.getLogger(SourceController.class);

  public SourceController(
      AgentyClient agentyClient) {
    this.agentyClient = agentyClient;
  }

  @GetMapping("/sources")
  public List<Result> fillSources() {

    List<Result> recentResults = agentyClient.getRecentResults();
    log.info(recentResults.toString());

    return recentResults;
  }
}
