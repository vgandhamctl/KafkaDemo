package com.enterprise.consumerex.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaProperties {

    @Value("${spring.kafka.bootstrap-servers}")
    private String BOOTSTRAP_SERVERS;

    @Value("#{'${spring.kafka.consumer.topic}'.split(',')}")//@Value("#{'${spring.kafka.consumer.correlator.topic}'.split(',')}")
    private List<String> TOPIC;

    @Value("${spring.kafka.consumer.groupid}")
    private String GROUP_ID;

    @Value("${spring.kafka.consumer.key.deserializer}")
    private String KEY_DESERIALIZER;

    @Value("${spring.kafka.consumer.value.deserializer}")
    private String VALUE_DESERIALIZER;

    /**
     * Getter to fetch Bootstrap Servers
     *
     * @return Kafka Brokers
     */
    public String getBOOTSTRAP_SERVERS() {
        return BOOTSTRAP_SERVERS;
    }

    /**
     * Setter to set Bootstrap Servers
     *
     * @param BOOTSTRAP_SERVERS Kafka Brokers
     */
    public void setBOOTSTRAP_SERVERS(String BOOTSTRAP_SERVERS) {
        this.BOOTSTRAP_SERVERS = BOOTSTRAP_SERVERS;
    }

    /**
     * @return Kafka Topic
     */
    public List<String> getTOPIC() {
        return TOPIC;
    }

    /**
     * @param TOPIC Kafka Topic
     */
    public void setTOPIC(List<String> TOPIC) {
        this.TOPIC = TOPIC;
    }

    /**
     * @return Kafka Consumer Group ID
     */
    public String getGROUP_ID() {
        return GROUP_ID;
    }

    /**
     * @param GROUP_ID Kafka Consumer Group ID
     */
    public void setGROUP_ID(String GROUP_ID) {
        this.GROUP_ID = GROUP_ID;
    }

    /**
     * @return Kafka Key Deserializer
     */
    public String getKEY_DESERIALIZER() {
        return KEY_DESERIALIZER;
    }

    /**
     * @param KEY_DESERIALIZER Kafka Key Deserializer
     */
    public void setKEY_DESERIALIZER(String KEY_DESERIALIZER) {
        this.KEY_DESERIALIZER = KEY_DESERIALIZER;
    }

    /**
     * @return Kafka Value Deserializer
     */
    public String getVALUE_DESERIALIZER() {
        return VALUE_DESERIALIZER;
    }

    /**
     * @param VALUE_DESERIALIZER Kafka Value Deserializer
     */
    public void setVALUE_DESERIALIZER(String VALUE_DESERIALIZER) {
        this.VALUE_DESERIALIZER = VALUE_DESERIALIZER;
    }

}
