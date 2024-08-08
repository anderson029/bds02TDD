package com.devsuperior.bds02.exceptions.dto;

import java.time.Instant;

public class ErrorResponseDTO {

  private Integer code;
  private String message;
  private Instant timestamp;

  public ErrorResponseDTO(Integer code, String message, Instant timestamp) {
    this.code = code;
    this.message = message;
    this.timestamp = timestamp;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }
}
