package com.chat.model;

import com.chat.enums.MessageType;
import lombok.Getter;

import java.awt.*;

@Getter
public class ChatMessageDto {
    private String chatRoomId;
    private String writer;
    private String message;
    private MessageType type;
}
