package com.example.emailnotification.service.message;

import com.example.emailnotification.model.PaymentDTO;
import com.example.emailnotification.service.send.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ConsumeServiceImpl implements ConsumeService {
    @Autowired
    private SendService sendService;

    @Override
    @KafkaListener(id = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.in}",
            containerFactory = "singleFactory")
    public void consumeMessage(List<PaymentDTO> message) {
        log.info("Message: {} successfully consumed", message);
        sendService.send(message);
    }
}
