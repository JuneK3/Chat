package com.rootlab.chat.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private String roomId;
    private MessageType type;
    private String sender;
    private String message;
}