package com.enterprise.consumerex.producer;

import com.enterprise.consumerex.models.MessageClass;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfigX {

    @Value("${spring.kafka.bootstrap-servers}")
    private String BOOTSTRAP_SERVERS;

    @Value("${spring.kafka.producer.key.serializer}")
    private String KEY_SERIALIZER;

    @Value("${spring.kafka.producer.value.serializer}")
    private String VALUE_SERIALIZER;

    @Value("${spring.kafka.producer.max.inflight.request.per.connection}")
    private int MAX_IN_FLIGHT_REQUEST_PER_CONNECTION;

    @Value("${spring.kafka.producer.retries}")
    private String RETRIES;

    @Value("${spring.kafka.producer.retries.ms}")
    private int RETRIES_MS;

    @Bean
    public ProducerFactory<String, MessageClass> producerFactory() {

        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KEY_SERIALIZER);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VALUE_SERIALIZER);
        config.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, MAX_IN_FLIGHT_REQUEST_PER_CONNECTION);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, "false");
        config.put(ProducerConfig.RETRIES_CONFIG, RETRIES);
        config.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, RETRIES_MS);

        return new DefaultKafkaProducerFactory<String, MessageClass>(config);
    }

    @Bean
    public KafkaTemplate<String, MessageClass> kafkaTemplate() {
        return new KafkaTemplate<String, MessageClass>(producerFactory());
    }

}
