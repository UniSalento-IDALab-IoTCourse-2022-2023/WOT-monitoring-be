package it.unisalento.iot.monitoringbe.repositories;

import it.unisalento.iot.monitoringbe.domains.AggregatedData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * interfaccia per effettuare le query riguardanti AggregatedData, nel database
 */
public interface IAggregatedDataRepository extends MongoRepository<AggregatedData, String> {

    Optional<AggregatedData> findByBoilerId(String boilerId);
    Optional<AggregatedData> findByTemperatureAverageData(float temperatureAverageData);
    Optional<AggregatedData> findByPressureAverageData(float pressureAverageData);
    Optional<AggregatedData> findByCarbonMonoxideAverageData(float carbonMonoxideAverageData);
    Optional<AggregatedData> findByPerformanceAverageData(float performanceAverageData);
}
