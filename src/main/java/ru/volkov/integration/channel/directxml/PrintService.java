package ru.volkov.integration.channel.directxml;

import org.springframework.messaging.Message;

public class PrintService {

    public void print(Message<String> message) {
        throw new RuntimeException("---WooooW---");
        //System.out.println(message.getPayload());
    }
}
