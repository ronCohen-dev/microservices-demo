package com.root.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = { "com.root.notification" , "com.root.rabbitmq" })
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);
    }

//@Bean
//    CommandLineRunner commandLineRunner (RabbitMQMessageProducer messageProducer , notificationConfig notificationConfig) {
//        return args -> {
//            messageProducer.publish(new Person("ron", 26) , notificationConfig.getInternalExchange()
//                    , notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
//    record Person(String name, int age){}
}
