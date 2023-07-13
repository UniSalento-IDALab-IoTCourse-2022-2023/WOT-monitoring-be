package it.unisalento.iot.monitoringbe.restControllers;

import it.unisalento.iot.monitoringbe.domains.Boiler;
import it.unisalento.iot.monitoringbe.dto.BoilerDTO;
import it.unisalento.iot.monitoringbe.repositories.IBoilerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monitoringbe/boiler")
public class BoilerRestController {

  @Autowired
  IBoilerRepository boilerRepository;
  @Autowired
  ModelMapper modelMapper;

  /**
   * restituisce lista dei boiler
   * @return LISTA DTO CON HTTP_STATUS OK
   */
  @GetMapping(value = "/getAll")
  public List<BoilerDTO> getAll(){

    List<BoilerDTO> boilerDTOList = new ArrayList<>();

    for (Boiler boiler : boilerRepository.findAll()){
      BoilerDTO boilerDTO = convertBoilerToBoilerDTO(Optional.ofNullable(boiler));
      boilerDTOList.add(boilerDTO);
    }

    return boilerDTOList;
  }

  /**
   * metodo per restituire in singolo boiler grazie all'id
   * @param id del boiler
   * @return boiler
   */
  @GetMapping(value = "/getById/{id}")
  public BoilerDTO getById(@PathVariable String id) {
    return convertBoilerToBoilerDTO(boilerRepository.findById(id));
  }

  /**
   * metodo per creare un nuovo profilo di un cittadino
   * @param boilerDTO DTO del boiler
   * @return exitcode + oggetto DTO del cittadino
   */
  @PostMapping(path="/createBoiler", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BoilerDTO> createBoiler(@RequestBody BoilerDTO boilerDTO) {

    Boiler boiler = convertBoilerDTOtoBoiler(boilerDTO);
    Boiler saved = boilerRepository.save(boiler);
    boilerDTO.setId(saved.getId());

    return new ResponseEntity<>(boilerDTO, HttpStatus.ACCEPTED);
  }

  // MODEL MAPPER:

  /**
   * converte il dto nella domain entity
   * @param boilerDTO oggetto DTO dell'allarme
   * @return boiler
   */
  private Boiler convertBoilerDTOtoBoiler(BoilerDTO boilerDTO){
    return modelMapper.map(boilerDTO, Boiler.class);
  }

  /**
   * converte la domanin entity nel DTO
   * @param boiler oggetto allarme
   * @return boilerDTO
   */
  private BoilerDTO convertBoilerToBoilerDTO(Optional<Boiler> boiler){
    return modelMapper.map(boiler, BoilerDTO.class);
  }
}
