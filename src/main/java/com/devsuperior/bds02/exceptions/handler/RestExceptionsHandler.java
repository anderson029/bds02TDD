package com.devsuperior.bds02.exceptions.handler;

import com.devsuperior.bds02.exceptions.BusinessException;
import com.devsuperior.bds02.exceptions.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class RestExceptionsHandler {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity handleBusinessException(BusinessException ex){
    ErrorResponseDTO error = new ErrorResponseDTO(ex.getCode(),ex.getMessage(), Instant.now());
    return ResponseEntity.status(ex.getHttpStatus()).body(error);
  }
}
