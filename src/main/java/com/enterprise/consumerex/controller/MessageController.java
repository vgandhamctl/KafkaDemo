package com.enterprise.consumerex.controller;

import com.enterprise.consumerex.manager.KafkaManager;
import com.enterprise.consumerex.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    ProducerService proService;

    @Autowired
    KafkaManager mgrKafka;

    @PostMapping(value = "/api/SendMessage")
    public String SendMessage(@RequestParam("message")String message)
    {
        proService.SendMEssage(message);
        return "OK";
    }

    @GetMapping(value = "/api/PauseConsumer")
    public String PauseConsumer()
    {
        mgrKafka.pause();
        return "OK";
    }

    @GetMapping(value = "/api/ResumeConsumer")
    public String ResumeConsumer()
    {
        mgrKafka.resume();
        return "OK";
    }


}
