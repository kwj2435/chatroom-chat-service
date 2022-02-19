package com.chat.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ChatMessage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private long messageId;
    private String sender;
    private String message;
    @Column(name = "create_date")
    private LocalDateTime createDate;
}
