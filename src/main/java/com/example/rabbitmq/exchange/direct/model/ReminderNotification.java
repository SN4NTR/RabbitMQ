package com.example.rabbitmq.exchange.direct.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReminderNotification {

	private String reminderMessage;

	private String reminderType;
}
