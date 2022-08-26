package com.nttdata.bootcamp.bank.kafka.consumer;

import com.nttdata.bootcamp.bank.springboot.service.inte.LocationServiceInte;
import com.nttdata.bootcamp.bank.springboot.document.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Component
@RestController
public class KafkaConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private LocationServiceInte locationServiceInte;

    /*@KafkaListener(topics = "TOPIC-DEMO" , groupId = "group_id")*/
    public void consume(String message) {

        logger.info("Consuming Message {}", message);
    }

    @KafkaListener(topics = "TOPIC-DEMO" , groupId = "group_id")
    @PostMapping
    public Mono<Location> consumeLocation(@RequestBody final Location location) {

        logger.info("Consuming Message {}", location);

        return locationServiceInte.create(location);

    }

}