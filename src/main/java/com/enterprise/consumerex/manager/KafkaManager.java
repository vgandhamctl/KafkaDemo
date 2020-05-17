package com.enterprise.consumerex.manager;

import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class KafkaManager {

    private final KafkaListenerEndpointRegistry registry;

    public KafkaManager(KafkaListenerEndpointRegistry registry) {
        this.registry = registry;
    }
    public void pause() {
        registry.getListenerContainers().forEach(MessageListenerContainer::pause);
    }

    public void resume() {
        registry.getListenerContainers().forEach(MessageListenerContainer::resume);
    }
}
