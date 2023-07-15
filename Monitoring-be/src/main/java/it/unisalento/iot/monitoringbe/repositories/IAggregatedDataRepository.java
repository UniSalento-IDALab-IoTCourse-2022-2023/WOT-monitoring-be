package it.unisalento.iot.monitoringbe.repositories;

import it.unisalento.iot.monitoringbe.domains.AggregatedData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * interfaccia per effettuare le query riguardanti AggregatedData, nel database
 */
public interface IAggregatedDataRepository extends MongoRepository<AggregatedData, String> {

    List<AggregatedData> findByBoilerId(String boilerId);
    List<AggregatedData> findByTemperatureAverageData(float temperatureAverageData);
    List<AggregatedData> findByPressureAverageData(float pressureAverageData);
    List<AggregatedData> findByCarbonMonoxideAverageData(float carbonMonoxideAverageData);
    List<AggregatedData> findByPerformanceAverageData(float performanceAverageData);
}
