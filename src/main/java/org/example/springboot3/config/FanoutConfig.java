package org.example.springboot3.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange("fanoutExchange");
//    }
//
//    @Bean
//    public Queue fanoutQueue1() {
//        return new Queue("fanoutQueue1");
//    }
//
//    @Bean
//    public Queue fanoutQueue2() {
//        return new Queue("fanoutQueue2");
//    }
//
//    @Bean
//    public Binding bindingQueue1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
//    }
//
//    @Bean
//    public Binding bindingQueue2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
//        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
//    }
}
