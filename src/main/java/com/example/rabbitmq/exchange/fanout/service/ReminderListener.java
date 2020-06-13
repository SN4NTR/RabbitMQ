package com.example.rabbitmq.exchange.fanout.service;

import com.example.rabbitmq.exchange.fanout.model.ReminderNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import static com.example.rabbitmq.exchange.direct.config.AmqpConfig.REMINDER_QUEUE_NAME;

@Service
public class ReminderListener {

	@RabbitListener(queues = REMINDER_QUEUE_NAME)
	public void listen(ReminderNotification notification, @Header("testHeader") String type) {
		System.out.println(type);
		System.out.println(notification);
	}
}
