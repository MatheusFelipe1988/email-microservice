package com.mail.service.producer;

import com.mail.service.domain.DTO.EmailDTO;
import com.mail.service.domain.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel){
        var emailDTO = new EmailDTO();
        emailDTO.setId(userModel.getId());
        emailDTO.setEmailTo(userModel.getEmail());
        emailDTO.setSubject("cadastro realizado com sucesso");
        emailDTO.setText(userModel.getNome() + ",seja vem vindo(a)m vindo(a)! \\nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa p");
        rabbitTemplate.convertAndSend("",routingKey, emailDTO);
    }
}
