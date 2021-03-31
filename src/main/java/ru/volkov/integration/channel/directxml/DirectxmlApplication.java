package ru.volkov.integration.channel.directxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@ImportResource("classpath:integration_context.xml")
public class DirectxmlApplication implements ApplicationRunner {

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(DirectxmlApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        for (int i = 0; i < 10; i++) {
            Message<String> message = MessageBuilder.withPayload("Printing message for payload " + i).build();
            this.gateway.print(message);
        }
    }
}
