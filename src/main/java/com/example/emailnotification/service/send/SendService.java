package com.example.emailnotification.service.send;

import com.example.emailnotification.model.PaymentDTO;

import java.util.List;

public interface SendService {
    void send(List<PaymentDTO> payments);
}
