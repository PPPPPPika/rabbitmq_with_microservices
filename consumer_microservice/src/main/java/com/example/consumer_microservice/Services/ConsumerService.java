package com.example.consumer_microservice.Services;

import com.example.consumer_microservice.Models.Estimate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(Estimate estimate){
        logger.info("Received estimate: " + estimate);
    }


}
