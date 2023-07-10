package it.unisalento.iot.monitoringbe.configurations;

import it.unisalento.iot.monitoringbe.domains.Boiler;
import it.unisalento.iot.monitoringbe.domains.User;
import it.unisalento.iot.monitoringbe.repositories.IBoilerRepository;
import it.unisalento.iot.monitoringbe.repositories.IUserRepository;
import it.unisalento.iot.monitoringbe.services.impl.ReceiverServiceImpl;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * classe per la configurazione della connessione col cassonetto
 */
@Configuration
public class ConnectionConfig {

  static final String boilerDataTopic = "boilerData-topic";
  static final String alarmTopic = "alarm-topic";
  static final String boilerDataQueue = "boilerData-queue";
  static final String alarmQueue = "alarm-queue";
  static final String routingKey = "gateway.boilerData.#";

  @Autowired
  IUserRepository userRepository;
  @Autowired
  IBoilerRepository boilerRepository;

  /**
   * metodo che inizializza una AMQP queue che non esisterà più dopo aver spento il server
   * @return della boilerDataQueue
   */
  @Bean
  public Queue boilerDataQueue() {
    return new Queue(boilerDataQueue, false);
  }

  /**
   * metodo che inizializza una AMQP queue che non esisterà più dopo aver spento il server
   * @return della alarmQueue
   */
  @Bean
  public Queue alarmQueue() {
    return new Queue(alarmQueue, false);
  }

  /**
   * metodo che inizializza il topic boilerData
   * @return del topic boilerData
   */
  @Bean
  public TopicExchange boilerDataTopicExchange() {
    return new TopicExchange(boilerDataTopic);
  }

  /**
   * metodo che inizializza il topic alarm
   * @return del topic waste
   */
  @Bean
  public TopicExchange alarmTopicExchange() {
    return new TopicExchange(alarmTopic);
  }

  /**
   * metodo che definisce il comportamento da avere quando `RabbitTemplate` effettua un
   *   publish su un topic associa al una certa queue un certo topic con routing key che
   *   include tutte le richieste inviate alle routing key che iniziano per "foo.bar."
   * @param boilerDataQueue (queue)
   * @param boilerDataTopicExchange (topic)
   * @return dell'oggeto che collega i due parametri
   */
  @Bean
  public Binding bindingWaste(Queue boilerDataQueue, TopicExchange boilerDataTopicExchange) {
    return BindingBuilder.bind(boilerDataQueue).to(boilerDataTopicExchange).with(routingKey);
  }

  /**
   * metodo che definisce il comportamento da avere quando `RabbitTemplate` effettua un
   *   publish su un topic associa al una certa queue un certo topic con routing key che
   *   include tutte le richieste inviate alle routing key che iniziano per "foo.bar."
   * @param alarmQueue (queue)
   * @param alarmTopicExchange (topic)
   * @return dell'oggeto che collega i due parametri
   */
  @Bean
  public Binding bindingAlarm(Queue alarmQueue, TopicExchange alarmTopicExchange) {
    return BindingBuilder.bind(alarmQueue).to(alarmTopicExchange).with(routingKey);
  }

  /**
   * metodo per settare il listener con:
   * @param connectionFactory (effettiva connessione creata)
   * @param boilerDataListenerAdapter (listener "ad alto livello" ceh delega ad altri listener)
   * @return del container
   */
  @Bean
  public SimpleMessageListenerContainer wasteContainer(ConnectionFactory connectionFactory, MessageListenerAdapter boilerDataListenerAdapter) {

    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(boilerDataQueue);
    container.setMessageListener(boilerDataListenerAdapter);

    return container;
  }

  /**
   * metodo per settare il listener con:
   * @param connectionFactory (effettiva connessione creata)
   * @param alarmListenerAdapter (listener "ad alto livello" ceh delega ad altri listener)
   * @return del container
   */
  @Bean
  public SimpleMessageListenerContainer alarmContainer(ConnectionFactory connectionFactory, MessageListenerAdapter alarmListenerAdapter) {

    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(alarmQueue);
    container.setMessageListener(alarmListenerAdapter);

    return container;
  }

  /**
   * metodo che effettua il listening che delega al receiver chiamando poi
   *   il metodo ReceiverServiceImpl.receiveBoilerData()
   * @param receiverServiceImpl servizio che riceve i dati
   * @return del listener
   */
  @Bean
  public MessageListenerAdapter boilerDataListenerAdapter(ReceiverServiceImpl receiverServiceImpl) {
    return new MessageListenerAdapter(receiverServiceImpl, "receiveBoilerData");
  }

  /**
   * metodo che effettua il listening che delega al receiver chiamando poi
   *   il metodo ReceiverServiceImpl.receiveAlarm()
   * @param receiverServiceImpl servizio che riceve i dati
   * @return del listener
   */
  @Bean
  public MessageListenerAdapter alarmListenerAdapter(ReceiverServiceImpl receiverServiceImpl) {
    return new MessageListenerAdapter(receiverServiceImpl, "receiveAlarm");
  }
}
