package com.example.rabbitmq.exchange.direct.controller;

import com.example.rabbitmq.exchange.direct.model.TimeBasedNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.rabbitmq.exchange.direct.config.AmqpConfig.EXCHANGE_NAME;
import static com.example.rabbitmq.exchange.direct.config.AmqpConfig.ROUTING_KEY;

@RestController
@RequestMapping("/timeBasedNotifications")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TimeBasedNotificationController {

	private final RabbitTemplate rabbitTemplate;

	@PostMapping
	public void send(@RequestBody TimeBasedNotification notification) {
		rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, notification, message -> {
			MessageProperties messageProperties = message.getMessageProperties();
			messageProperties.setHeader("testHeader", "timeBased");
			return message;
		});
	}
}
