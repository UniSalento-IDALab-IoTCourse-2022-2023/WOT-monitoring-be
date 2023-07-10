package it.unisalento.iot.monitoringbe.repositories;

import it.unisalento.iot.monitoringbe.domains.Alarm;
import it.unisalento.iot.monitoringbe.domains.AlarmType;
import it.unisalento.iot.monitoringbe.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * interfaccia per effettuare le query riguardanti gli user, nel database
 */
public interface IUserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
    Optional<User> findBySurname(String surname);
    Optional<User> findByBoilerId(String boilerId);
}
