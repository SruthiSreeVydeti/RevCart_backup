package com.revcart.notification.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "notifications")
@Data
public class Notification {
    @Id
    private String id;
    private Long userId;
    private String type;
    private String title;
    private String message;
    private boolean read = false;
    private LocalDateTime createdAt = LocalDateTime.now();
}
