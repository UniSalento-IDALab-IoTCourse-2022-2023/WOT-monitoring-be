package it.unisalento.iot.monitoringbe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * classe per definire un errore custom
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class WrongTopicExchangeException extends Exception{
  public WrongTopicExchangeException() {
    System.out.print("Error! Your topic is wrong and/or null.");
  }
}
