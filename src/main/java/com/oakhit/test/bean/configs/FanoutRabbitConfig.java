package com.oakhit.test.bean.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    public final static String FANOUT_A = "fanout.A";
    public final static String FANOUT_B = "fanout.B";
    public final static String FANOUT_C = "fanout.C";
    public final static String EXCHANGE = "fanoutExchange";

    @Bean
    public Queue AMessage() {
        return new Queue(FANOUT_A);
    }

    @Bean
    public Queue BMessage() {
        return new Queue(FANOUT_B);
    }

    @Bean
    public Queue CMessage() {
        return new Queue(FANOUT_C);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}