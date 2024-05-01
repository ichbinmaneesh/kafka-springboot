package com.tutorial.kafka.controllers;

import com.tutorial.kafka.payload.User;
import com.tutorial.kafka.producer.JsonKafkaProducer;
import com.tutorial.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class ProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        //kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to kafka...");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User message){
        jsonKafkaProducer.sendMessage(message);
        return ResponseEntity.ok("JSON Message sent to kafka...");
    }
}
