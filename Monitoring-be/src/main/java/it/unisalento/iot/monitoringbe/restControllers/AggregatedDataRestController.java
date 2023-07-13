package it.unisalento.iot.monitoringbe.restControllers;

import it.unisalento.iot.monitoringbe.domains.AggregatedData;
import it.unisalento.iot.monitoringbe.domains.Alarm;
import it.unisalento.iot.monitoringbe.domains.AlarmType;
import it.unisalento.iot.monitoringbe.dto.AggregatedDataDTO;
import it.unisalento.iot.monitoringbe.dto.AlarmDTO;
import it.unisalento.iot.monitoringbe.repositories.IAggregatedDataRepository;
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
@RequestMapping("/api/monitoringbe/aggregatedData")
public class AggregatedDataRestController {

  @Autowired
  IAggregatedDataRepository aggregatedDataRepository;
  @Autowired
  ModelMapper modelMapper;

  /**
   * restituisce lista degli aggregatedData
   * @return LISTA DTO CON HTTP_STATUS OK
   */
  @GetMapping(value = "/getAll")
  public List<AggregatedDataDTO> getAll(){

    List<AggregatedDataDTO> aggregatedDataDTOList = new ArrayList<>();

    for (AggregatedData aggregatedData : aggregatedDataRepository.findAll()){
      AggregatedDataDTO aggregatedDataDTO = convertAggregatedDataToAggregatedDataDTO(Optional.ofNullable(aggregatedData));
      aggregatedDataDTOList.add(aggregatedDataDTO);
    }

    return aggregatedDataDTOList;
  }

  /**
   * metodo per restituire in singolo aggregatedData grazie all'id
   * @param id del aggregatedData
   * @return aggregatedData
   */
  @GetMapping(value = "/getById/{id}")
  public AggregatedDataDTO getById(@PathVariable String id) {
    return convertAggregatedDataToAggregatedDataDTO(aggregatedDataRepository.findById(id));
  }

  /**
   * metodo per restituire una lista di aggregatedData in base al boilerId
   * @param boilerId identificativo del boiler
   * @return lista di aggregatedData
   */
  @GetMapping(value = "/getByBoilerId/{boilerId}")
  public List<AggregatedDataDTO> getByBoilerId(@PathVariable String boilerId) {
    return Collections.singletonList(convertAggregatedDataToAggregatedDataDTO(aggregatedDataRepository.findByBoilerId(boilerId)));
  }

  /**
   * metodo per restituire una lista di aggregatedData in base al temperatureAverageData
   * @param temperatureAverageData temperatura media
   * @return lista di aggregatedData
   */
  @GetMapping(value = "/getByTemperatureAverageData/{temperatureAverageData}")
  public List<AggregatedDataDTO> getByTemperatureAverageData(@PathVariable float temperatureAverageData) {
    return Collections.singletonList(convertAggregatedDataToAggregatedDataDTO(aggregatedDataRepository.findByTemperatureAverageData(temperatureAverageData)));
  }

  /**
   * metodo per restituire una lista di aggregatedData in base al pressureAverageData
   * @param pressureAverageData pressione media
   * @return lista di aggregatedData
   */
  @GetMapping(value = "/getByPressureAverageData/{pressureAverageData}")
  public List<AggregatedDataDTO> getByPressureAverageData(@PathVariable float pressureAverageData) {
    return Collections.singletonList(convertAggregatedDataToAggregatedDataDTO(aggregatedDataRepository.findByPressureAverageData(pressureAverageData)));
  }

  /**
   * metodo per restituire una lista di aggregatedData in base al carbonMonoxideAverageData
   * @param carbonMonoxideAverageData CO media
   * @return lista di aggregatedData
   */
  @GetMapping(value = "/getByCarbonMonoxideAverageData/{carbonMonoxideAverageData}")
  public List<AggregatedDataDTO> getByCarbonMonoxideAverageData(@PathVariable float carbonMonoxideAverageData) {
    return Collections.singletonList(convertAggregatedDataToAggregatedDataDTO(aggregatedDataRepository.findByCarbonMonoxideAverageData(carbonMonoxideAverageData)));
  }

  /**
   * metodo per restituire una lista di aggregatedData in base al performanceAverageData
   * @param performanceAverageData identificativo del cassonetto
   * @return lista di aggregatedData
   */
  @GetMapping(value = "/getByPerformanceAverageData/{performanceAverageData}")
  public List<AggregatedDataDTO> getByPerformanceAverageData(@PathVariable float performanceAverageData) {
    return Collections.singletonList(convertAggregatedDataToAggregatedDataDTO(aggregatedDataRepository.findByPerformanceAverageData(performanceAverageData)));
  }

  // MODEL MAPPER:

  /**
   * converte il dto nella domain entity
   * @param aggregatedDataDTO oggetto DTO dell'aggregatedData
   * @return aggregatedData
   */
  private AggregatedData convertAggregatedDataDTOtoAggregatedData(AggregatedDataDTO aggregatedDataDTO){
    return modelMapper.map(aggregatedDataDTO, AggregatedData.class);
  }

  /**
   * converte la domanin entity nel DTO
   * @param aggregatedData oggetto aggregatedData
   * @return aggregatedDataDTO
   */
  private AggregatedDataDTO convertAggregatedDataToAggregatedDataDTO(Optional<AggregatedData> aggregatedData){
    return modelMapper.map(aggregatedData, AggregatedDataDTO.class);
  }
}
