package com.busra.springbootexercises;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {
    public String printMessage(){
        return "Hello Springboot";
    }
}
