package com.devsuperior.bds02.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{
  private Integer code;
  private HttpStatus httpStatus;

  public BusinessException(Integer code,String message, HttpStatus httpStatus) {
    super(message);
    this.code = code;
    this.httpStatus = httpStatus;
  }

  public Integer getCode() {
    return code;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }
}
