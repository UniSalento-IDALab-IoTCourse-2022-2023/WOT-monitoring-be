package it.unisalento.iot.monitoringbe.repositories;

import it.unisalento.iot.monitoringbe.domains.Boiler;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * interfaccia per effettuare le query riguardanti i boiler, nel database
 */
public interface IBoilerRepository extends MongoRepository<Boiler, String> {
}
