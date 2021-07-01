package com.projearq.stockMS.adapters.configurations.rollbackstockqueue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockRollbackQueueConfiguration {

    static final String topicExchangeNameRollback = "stock-rollback-exchange";

    static final String queueNameRollback = "stock-rollback";

    @Bean
    Queue stockRollbackQueue() {
        return new Queue(queueNameRollback, false);
    }

    @Bean
    TopicExchange stockRollbackExchange() {
        return new TopicExchange(topicExchangeNameRollback);
    }

    @Bean
    Binding stockRollbackBinding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("stockRollback.#");
    }

    @Bean
    SimpleMessageListenerContainer stockRollbackContainer(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueNameRollback);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter stockRollbackListenerAdapter(RollbackStockReceiver rollbackStockReceiver) {
        return new MessageListenerAdapter(rollbackStockReceiver, "receive");
    }

}
