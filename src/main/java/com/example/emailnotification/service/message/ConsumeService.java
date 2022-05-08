package com.example.emailnotification.service.message;

import com.example.emailnotification.model.PaymentDTO;

import java.util.List;

public interface ConsumeService {
    void consumeMessage(List<PaymentDTO> paymentDTO);
}
