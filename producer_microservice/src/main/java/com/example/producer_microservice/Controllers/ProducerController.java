package com.example.producer_microservice.Controllers;

import com.example.producer_microservice.Models.Estimate;
import com.example.producer_microservice.Services.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    private ProducerService producerService;
    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/produce")
    public ResponseEntity<String> sendMessage(@RequestBody Estimate estimate){
        producerService.sendMessage(estimate);
        logger.info("Estimate: " + estimate);
        return ResponseEntity.ok("Estimate was send!");
    }


}
