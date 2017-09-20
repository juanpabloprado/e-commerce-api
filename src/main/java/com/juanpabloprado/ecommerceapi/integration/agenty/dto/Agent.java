package com.juanpabloprado.ecommerceapi.integration.agenty.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {
  private String agentId;
  private String status;
  private Long version;
  private Long jobId;
  private String startedAt;
  private String completedAt;
  private int total;
  private int limit;
  private int offset;
  private int returned;
  private Result[] result;

  protected Agent() {
  }

  public String getAgentId() {
    return agentId;
  }

  public void setAgentId(String agentId) {
    this.agentId = agentId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public Long getJobId() {
    return jobId;
  }

  public void setJobId(Long jobId) {
    this.jobId = jobId;
  }

  public String getStartedAt() {
    return startedAt;
  }

  public void setStartedAt(String startedAt) {
    this.startedAt = startedAt;
  }

  public String getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(String completedAt) {
    this.completedAt = completedAt;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getReturned() {
    return returned;
  }

  public void setReturned(int returned) {
    this.returned = returned;
  }

  public Result[] getResult() {
    return result;
  }

  public void setResult(Result[] result) {
    this.result = result;
  }

  @Override public String toString() {
    return "Agent{" +
        "agentId='" + agentId + '\'' +
        ", status='" + status + '\'' +
        ", version=" + version +
        ", jobId=" + jobId +
        ", result=" + Arrays.toString(result) +
        '}';
  }
}
