package it.unisalento.iot.monitoringbe.restControllers;

import it.unisalento.iot.monitoringbe.domains.Alarm;
import it.unisalento.iot.monitoringbe.domains.AlarmType;
import it.unisalento.iot.monitoringbe.domains.User;
import it.unisalento.iot.monitoringbe.dto.AlarmDTO;
import it.unisalento.iot.monitoringbe.dto.UserDTO;
import it.unisalento.iot.monitoringbe.repositories.IAlarmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monitoringbe/alarm")
public class AlarmRestController {

  @Autowired
  IAlarmRepository alarmRepository;
  @Autowired
  ModelMapper modelMapper;

  /**
   * restituisce lista dei alarm
   * @return LISTA DTO CON HTTP_STATUS OK
   */
  @GetMapping(value = "/getAll")
  public List<AlarmDTO> getAll(){

    List<AlarmDTO> alarmDTOList = new ArrayList<>();

    for (Alarm alarm : alarmRepository.findAll()){
      AlarmDTO alarmDTO = convertAlarmToAlarmDTO(Optional.ofNullable(alarm));
      alarmDTOList.add(alarmDTO);
    }

    return alarmDTOList;
  }

  /**
   * metodo per restituire in singolo alarm grazie all'id
   * @param id del alarm
   * @return alarm
   */
  @GetMapping(value = "/getById/{id}")
  public AlarmDTO getById(@PathVariable String id) {
    return convertAlarmToAlarmDTO(alarmRepository.findById(id));
  }

  /**
   * metodo per restituire una lista di alarm in base al tipo di rifiuto
   * @param alarmType enum per il tipo di allarme
   * @return lista di alarm
   */
  @GetMapping(value = "/getByAlarmType/{alarmType}")
  public List<AlarmDTO> getByAlarmType(@PathVariable AlarmType alarmType) {
    return convertAlarmListToAlarmDTOList(alarmRepository.findByAlarmType(alarmType));
  }

  /**
   * metodo per restituire una lista di alarm in base al boilerId
   * @param boilerId identificativo del boiler
   * @return lista di alarm
   */
  @GetMapping(value = "/getByBoilerId/{boilerId}")
  public List<AlarmDTO> getByBoilerId(@PathVariable String boilerId) {
    return convertAlarmListToAlarmDTOList(alarmRepository.findByBoilerId(boilerId));
  }

  // MODEL MAPPER:

  /**
   * converte il dto nella domain entity
   * @param alarmDTO oggetto DTO dell'allarme
   * @return alarm
   */
  private Alarm convertAlarmDTOtoAlarm(AlarmDTO alarmDTO){
    return modelMapper.map(alarmDTO, Alarm.class);
  }

  /**
   * converte la domanin entity nel DTO
   * @param alarm oggetto allarme
   * @return alarmDTO
   */
  private AlarmDTO convertAlarmToAlarmDTO(Optional<Alarm> alarm){
    return modelMapper.map(alarm, AlarmDTO.class);
  }

  /**
   * converte la domanin entity nel DTO
   * @param alarmList oggetto allarme
   * @return alarmDTO
   */
  private List<AlarmDTO> convertAlarmListToAlarmDTOList(List<Alarm> alarmList){
    List<AlarmDTO> alarmDTOs = new ArrayList<>();

    for (Alarm alarm : alarmList){
      alarmDTOs.add(modelMapper.map(alarm, AlarmDTO.class));
    }

    return alarmDTOs;
  }
}
