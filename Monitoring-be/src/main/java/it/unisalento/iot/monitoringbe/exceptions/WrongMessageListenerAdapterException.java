package it.unisalento.iot.monitoringbe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * classe per definire un errore custom
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class WrongMessageListenerAdapterException extends Exception{
  public WrongMessageListenerAdapterException() {
    System.out.print("Error! Your message listener is wrong and/or null.");
  }
}
