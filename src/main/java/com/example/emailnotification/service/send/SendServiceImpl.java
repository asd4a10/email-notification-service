package com.example.emailnotification.service.send;

import com.example.emailnotification.feign.ClientFeign;
import com.example.emailnotification.model.ClientModel;
import com.example.emailnotification.model.PaymentDTO;
import com.example.emailnotification.service.email.EmailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class SendServiceImpl implements SendService {
    @Autowired
    ClientFeign clientFeign;
    @Autowired
    EmailSenderService emailSenderService;

    @Override
    public void send(List<PaymentDTO> payments) {
        ClientModel clientModel = clientFeign.getClientById(payments.get(0).getClientId());
        Random random=new Random();
        int totalSum=0, order=random.nextInt()%100;
        String subject="Оплата квитанции №"+order;
        String clientBody="Оплачены услуги:\n";
        String employeeBody="Клиент "+clientModel.getName()+
                " успешно оплатил квитанцию №"+order+"\n";

        System.out.println(payments);
        System.out.println(clientModel);

        for (PaymentDTO paymentDTO: payments) {
            if (paymentDTO.isPaid()) continue;
            clientBody+=paymentDTO.getDescription()+" - "+paymentDTO.getCost()+"\n";
            totalSum+=paymentDTO.getCost();
        }
        employeeBody+="Общая сумма оплаты составила "+totalSum+" тенге\n";
        clientBody+="Всего: "+totalSum;

        emailSenderService.sendEmail(clientModel.getEmail(), subject, clientBody);
        emailSenderService.sendEmail("amanzholov000@gmail.com", subject, employeeBody);
    }
}
