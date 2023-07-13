package it.unisalento.iot.monitoringbe.restControllers;

import it.unisalento.iot.monitoringbe.domains.User;
import it.unisalento.iot.monitoringbe.dto.UserDTO;
import it.unisalento.iot.monitoringbe.repositories.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monitoringbe/user")
public class UserRestController {

  @Autowired
  IUserRepository userRepository;
  @Autowired
  ModelMapper modelMapper;

  /**
   * restituisce lista dei user
   * @return LISTA DTO CON HTTP_STATUS OK
   */
  @GetMapping(value = "/getAll")
  public List<UserDTO> getAll(){

    List<UserDTO> userDTOList = new ArrayList<>();

    for (User user : userRepository.findAll()){
      UserDTO userDTO = convertUserToUserDTO(Optional.ofNullable(user));
      userDTOList.add(userDTO);
    }

    return userDTOList;
  }

  /**
   * metodo per restituire in singolo user grazie all'id
   * @param id del user
   * @return user
   */
  @GetMapping(value = "/getById/{id}")
  public UserDTO getById(@PathVariable String id) {
    return convertUserToUserDTO(userRepository.findById(id));
  }

  /**
   * metodo per restituire una lista di user in base al boilerId
   * @param boilerId identificativo del boiler
   * @return lista di user
   */
  @GetMapping(value = "/getByBoilerId/{boilerId}")
  public List<UserDTO> getByBoilerId(@PathVariable String boilerId) {
    return Collections.singletonList(convertUserToUserDTO(userRepository.findByBoilerId(boilerId)));
  }

  /**
   * metodo per restituire una lista di user in base al temperatureAverageData
   * @param name nome dello user
   * @return lista di user
   */
  @GetMapping(value = "/getByName/{name}")
  public List<UserDTO> getByName(@PathVariable String name) {
    return Collections.singletonList(convertUserToUserDTO(userRepository.findByName(name)));
  }

  /**
   * metodo per restituire una lista di user in base al temperatureAverageData
   * @param surname cgnome dello user
   * @return lista di user
   */
  @GetMapping(value = "/getBySurname/{surname}")
  public List<UserDTO> getBySurname(@PathVariable String surname) {
    return Collections.singletonList(convertUserToUserDTO(userRepository.findBySurname(surname)));
  }

  /**
   * metodo per restituire una lista di user in base al temperatureAverageData
   * @param email email dello user
   * @return lista di user
   */
  @GetMapping(value = "/getByEmail/{email}")
  public List<UserDTO> getByEmail(@PathVariable String email) {
    return Collections.singletonList(convertUserToUserDTO(userRepository.findByEmail(email)));
  }

  /**
   * metodo per restituire una lista di user in base al temperatureAverageData
   * @param address indirizzo dello user
   * @return lista di user
   */
  @GetMapping(value = "/getByAddress/{address}")
  public List<UserDTO> getByAddress(@PathVariable String address) {
    return Collections.singletonList(convertUserToUserDTO(userRepository.findByAddress(address)));
  }

  /**
   * metodo per creare un nuovo profilo di un cittadino
   * @param userDTO DTO del user
   * @return exitcode + oggetto DTO del cittadino
   */
  @PostMapping(path="/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {

    User user = convertUserDTOtoUser(userDTO);
    User saved = userRepository.save(user);
    userDTO.setId(saved.getId());

    return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
  }

  // MODEL MAPPER:

  /**
   * converte il dto nella domain entity
   * @param userDTO oggetto DTO dell'allarme
   * @return user
   */
  private User convertUserDTOtoUser(UserDTO userDTO){
    return modelMapper.map(userDTO, User.class);
  }

  /**
   * converte la domanin entity nel DTO
   * @param user oggetto allarme
   * @return userDTO
   */
  private UserDTO convertUserToUserDTO(Optional<User> user){
    return modelMapper.map(user, UserDTO.class);
  }
}
