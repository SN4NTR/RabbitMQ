package com.example.rabbitmq.exchange.direct.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

	public static final String REMINDER_QUEUE_NAME = "reminder.queue";
	public static final String TIME_BASED_NOTIFICATION_QUEUE_NAME = "time-based.queue";

	public static final String EXCHANGE_NAME = "direct.exchange";
	public static final String ROUTING_KEY = "routing-key";

	@Bean
	public Queue reminderQueue() {
		return new Queue(REMINDER_QUEUE_NAME, false);
	}

	@Bean
	public Queue timeBasedNotificationQueue() {
		return new Queue(TIME_BASED_NOTIFICATION_QUEUE_NAME, false);
	}

	@Bean
	public Binding reminderBinding(Queue reminderQueue, Exchange exchange) {
		return BindingBuilder.bind(reminderQueue)
				.to(exchange)
				.with(ROUTING_KEY)
				.noargs();
	}

	@Bean
	public Binding timeBasedNotificationBinding(Queue timeBasedNotificationQueue, Exchange exchange) {
		return BindingBuilder.bind(timeBasedNotificationQueue)
				.to(exchange)
				.with(ROUTING_KEY)
				.noargs();
	}

	@Bean
	public Exchange exchange() {
		return new DirectExchange(EXCHANGE_NAME);
	}

	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);
		return rabbitTemplate;
	}
}
