package com.busra.springbootexercises;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessagePrinter messagePrinter;
    public MessageService(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public String printMessage() {
        return messagePrinter.printMessage();
    }
}
