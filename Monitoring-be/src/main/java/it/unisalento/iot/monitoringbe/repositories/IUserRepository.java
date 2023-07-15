package it.unisalento.iot.monitoringbe.repositories;

import it.unisalento.iot.monitoringbe.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * interfaccia per effettuare le query riguardanti gli user, nel database
 */
public interface IUserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    List<User> findByAddress(String address);
    Optional<User> findByBoilerId(String boilerId);
}
