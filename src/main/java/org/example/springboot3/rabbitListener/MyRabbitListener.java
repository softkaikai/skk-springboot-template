package org.example.springboot3.rabbitListener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1", durable = "true"),
            exchange = @Exchange(name = "directExchange", type = ExchangeTypes.DIRECT),
            key = {"red"}
    ))
    public void listenMessage1(HashMap<String, String> msg) {
        System.out.println("消费者1接受到的消息：" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2", durable = "true"),
            exchange = @Exchange(name = "directExchange", type = ExchangeTypes.DIRECT),
            key = {"orange"}
    ))
    public void listenMessage2(HashMap<String, String> msg) {
        System.out.println("消费者2接受到的消息：" + msg);
    }
}
