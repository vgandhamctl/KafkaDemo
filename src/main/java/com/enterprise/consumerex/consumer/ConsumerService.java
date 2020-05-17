package com.enterprise.consumerex.consumer;

import com.enterprise.consumerex.models.MessageClass;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
    @Autowired
    KafkaProperties kafkaProperties;
    @Autowired
    Gson gson;

    @KafkaListener(topics = "#{kafkaProperties.getTOPIC()}",
            groupId = "#{kafkaProperties.getGROUP_ID()}")
    public void consumes(Object object) throws Exception {
        try {
            Object obj = ((ConsumerRecord) object).value();
           // MessageClass msg = gson.fromJson((String) obj, MessageClass.class);

        logger.info("message received is {} ", obj.toString());

        } catch (Exception e) {
            logger.error("incorrect message received");
        }
    }

}
