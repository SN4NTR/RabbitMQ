package com.example.rabbitmq.exchange.direct.service;

import com.example.rabbitmq.exchange.direct.model.TimeBasedNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import static com.example.rabbitmq.exchange.direct.config.AmqpConfig.TIME_BASED_NOTIFICATION_QUEUE_NAME;

@Service
public class TimeBasedNotificationListener {

	@RabbitListener(queues = TIME_BASED_NOTIFICATION_QUEUE_NAME)
	public void listen(TimeBasedNotification notification, @Header("testHeader") String type) {
		System.out.println(type);
		System.out.println(notification);
	}
}
