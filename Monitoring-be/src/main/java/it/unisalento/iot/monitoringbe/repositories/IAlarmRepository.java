package it.unisalento.iot.monitoringbe.repositories;

import it.unisalento.iot.monitoringbe.domains.Alarm;
import it.unisalento.iot.monitoringbe.domains.AlarmType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * interfaccia per effettuare le query riguardanti alarm, nel database
 */
public interface IAlarmRepository extends MongoRepository<Alarm, String> {

  List<Alarm> findByAlarmType(AlarmType alarmType);
  List<Alarm> findByBoilerId(String boilerId);
}
