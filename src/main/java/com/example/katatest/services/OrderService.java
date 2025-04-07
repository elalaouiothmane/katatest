package com.example.katatest.services;

import com.example.katatest.model.DeliveryMode;
import com.example.katatest.model.Order;
import com.example.katatest.repositories.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.example.katatest.consts.Constants.MINIMUM_DELIVERY_DURATION;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final KafkaTemplate  kafkaTemplate;

    public OrderService(OrderRepository orderRepository, KafkaTemplate kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Mono<Order> createOrder(Order order){
        if(validateOrder(order) !=null){
             kafkaTemplate.send("topicName",order);
             return orderRepository.save(order);

        }
        return null;
    }

    public Order validateOrder(Order order){
        if(order.getCreatedAt().isBefore(order.getDeliveryDate())){
            if(DeliveryMode.DELIVERY_TODAY.equals(order.getDeliveryMode()) || DeliveryMode.DRIVE.equals(order.getDeliveryMode())){
                if(order.getDeliveryDate().plusMinutes(MINIMUM_DELIVERY_DURATION).isBefore(order.getDeliveryDate().plusHours(1))){
                    return order;
                }
            }
        }
        return null;
    }
}
