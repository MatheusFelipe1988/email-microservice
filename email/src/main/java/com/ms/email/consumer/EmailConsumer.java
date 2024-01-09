package com.ms.email.consumer;

import com.ms.email.domain.DTO.EmailDTO;
import com.ms.email.domain.EmailModel;
import com.ms.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    final EmailService service;

    public EmailConsumer(EmailService service) {
        this.service = service;
    }


    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDTO emailDTO){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        service.sendEmail(emailModel);
    }

}
