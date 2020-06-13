//package com.example.demo.service;
//
//import com.example.demo.model.ReminderNotification;
//import com.example.demo.model.TimeBasedNotification;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//import static com.example.demo.config.AmqpConfig.QUEUE_NAME;
//
//@Service
//@RabbitListener(queues = QUEUE_NAME)
//public class MultiListener {
//
//	@RabbitHandler
//	public void listenTimeBasedNotifications(TimeBasedNotification timeBasedNotification) {
//		System.out.println(timeBasedNotification);
//	}
//
//	@RabbitHandler
//	public void listenReminders(ReminderNotification reminder) {
//		System.out.println(reminder);
//	}
//}
