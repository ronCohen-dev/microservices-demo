package com.root.customer.services;

import com.root.clients.fraud.FraudCheckResponse;
import com.root.clients.fraud.FraudClient;
import com.root.clients.notification.NotificationClient;
import com.root.clients.notification.NotificationRequest;
import com.root.customer.models.Customer;
import com.root.customer.models.CustomerRegistertionRequest;
import com.root.customer.repository.CustomerRepository;
import com.root.rabbitmq.producer.RabbitMQMessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer producer;
    public void registerCustomer(CustomerRegistertionRequest customerRequest) {
        Customer customer = Customer.builder().firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName()).email(customerRequest.email()).build();
        // todo: store customer in db
        customerRepository.saveAndFlush(customer);

        // todo: check if email valid
        // todo: check if email not taken

        // todo: call with eureka server and rest template
//        FraudCheckResponse fraudCheckResponse =  restTemplate.getForObject("http://FRAUD/api/fraud-check/{customerId}"
//                , FraudCheckResponse.class,customer.getId());

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        // todo: check if fraudster
        if (fraudCheckResponse.isFraudster()) throw new IllegalStateException("is fraudster");


        // todo: send a notification
        NotificationRequest notificationRequest = new NotificationRequest(customer.getId(), customer.getFirstName()
                ,String.format("Hi %s, welcome to ron's server app ...", customer.getFirstName()));
        producer.publish(notificationRequest,"internal.exchange","internal.notification.routing-key");

    }
}
