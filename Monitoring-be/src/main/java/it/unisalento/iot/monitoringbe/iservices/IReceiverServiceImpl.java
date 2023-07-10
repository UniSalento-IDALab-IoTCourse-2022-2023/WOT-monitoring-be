package it.unisalento.iot.monitoringbe.iservices;

import it.unisalento.iot.monitoringbe.exceptions.ResourceNotFoundException;

public interface IReceiverServiceImpl {

  /**
   * metodo per ascoltare sulla queue del boiler data
   * @param jsonBoilerDataInfo stringa in formato json per le waste
   */
  void receiveBoilerData(String jsonBoilerDataInfo) throws ResourceNotFoundException;

  /**
   * metodo per ascoltare sulla queue dell'alarm
   * @param jsonAlarmInfo stringa in formato json per l'allarme
   */
  void receiveAlarm(String jsonAlarmInfo) throws ResourceNotFoundException;
}
