package com.enterprise.consumerex.consumer;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

public class ConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String BOOTSTRAP_SERVERS;

    @Value("${spring.kafka.consumer.groupid}")
    private String GROUP_ID;

    @Value("${spring.kafka.consumer.key.deserializer}")
    private String KEY_DESERIALIZER;

    @Value("${spring.kafka.consumer.value.deserializer}")
    private String VALUE_DESERIALIZER;

    @Value("${auto.offset.reset}")
    private String AUTO_OFFSET_RESET;


    /**
     * Create Kafka Consumer Factory
     *
     * @return Consumer Factory
     */
    @Bean
    public ConsumerFactory<String, Object> userConsumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KEY_DESERIALIZER);
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VALUE_DESERIALIZER);
        config.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KEY_DESERIALIZER);
        config.put(JsonDeserializer.TRUSTED_PACKAGES,"*");
        return new DefaultKafkaConsumerFactory(config, new StringDeserializer(), new StringDeserializer());
    }

    /**
     * Create Kafka Listener Container
     *
     * @return ConcurrentKafkaListenerContainerFactory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        factory.setConcurrency(1);
        return factory;
    }

}
