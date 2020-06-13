package com.example.rabbitmq.exchange.fanout.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeBasedNotification {

	private String notificationMessage;

	private String notificationType;
}
