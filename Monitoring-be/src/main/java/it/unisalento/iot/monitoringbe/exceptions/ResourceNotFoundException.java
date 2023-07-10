package it.unisalento.iot.monitoringbe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
  public ResourceNotFoundException() {
    System.out.print("Error! Your resource was not found.");
  }
}