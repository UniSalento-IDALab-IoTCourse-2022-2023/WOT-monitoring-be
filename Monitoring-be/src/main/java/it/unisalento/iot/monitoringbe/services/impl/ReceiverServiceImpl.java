package it.unisalento.iot.monitoringbe.services.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.unisalento.iot.monitoringbe.domains.*;
import it.unisalento.iot.monitoringbe.exceptions.ResourceNotFoundException;
import it.unisalento.iot.monitoringbe.iservices.IReceiverServiceImpl;
import it.unisalento.iot.monitoringbe.repositories.IAlarmRepository;
import it.unisalento.iot.monitoringbe.repositories.IBoilerRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class ReceiverServiceImpl implements IReceiverServiceImpl {

  @Autowired
  IAlarmRepository alarmRepository;
  @Autowired
  IBoilerRepository boilerRepository;

  // per intercettare le richieste
  private final CountDownLatch latch = new CountDownLatch(1);

  @Override
  @RabbitListener(queues="boilerData-queue")
  public void receiveBoilerData(String jsonBoilerDataInfo) throws ResourceNotFoundException {
    System.out.println("\n+---------------- - -  -  -   -\nREQUEST received: " + jsonBoilerDataInfo + "\n+---------------- - -  -  -   -\n");

    Gson gson = new Gson();

    boilerRepository.save(gson.fromJson(jsonBoilerDataInfo, Boiler.class));

    latch.countDown();
  }

  @Override
  @RabbitListener(queues="alarm-queue")
  public void receiveAlarm(String jsonAlarmInfo) throws ResourceNotFoundException {
    System.out.println("\n+---------------- - -  -  -   -\n🚨 ALARM received: " + jsonAlarmInfo + "\n+---------------- - -  -  -   -\n");

    Gson gson = new Gson();

    alarmRepository.save(gson.fromJson(jsonAlarmInfo, Alarm.class));

    latch.countDown();
  }
}
