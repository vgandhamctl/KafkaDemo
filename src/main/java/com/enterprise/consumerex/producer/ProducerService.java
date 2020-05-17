package com.enterprise.consumerex.producer;

import com.enterprise.consumerex.models.MessageClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
public class ProducerService {

    Logger logger = LoggerFactory.getLogger(MessageClass.class);

    @Autowired
    private KafkaTemplate<String, MessageClass> kafkaTemplate;

    public boolean SendMEssage(String Message)
    {
        MessageClass msg = new MessageClass(Message, Message);

        int arr[]={12,13,14,44};

    for (int i : arr) {
      msg.setMessage("Setting New Message " + i);
      ListenableFuture<SendResult<String, MessageClass>> future =
          kafkaTemplate.send("mydata", "50", msg);

      future.addCallback(
          new ListenableFutureCallback<SendResult<String, MessageClass>>() {
            @Override
            public void onSuccess(final SendResult<String, MessageClass> message) {
              logger.info("message sent sucessfully");
            }

            @Override
            public void onFailure(final Throwable throwable) {
              logger.error("Unable to send message", throwable);
            }
          });
        }

        return true;
    }
}
