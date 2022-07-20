package com.root.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = { "com.root.notification" , "com.root.rabbitmq" })
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);
    }
}
