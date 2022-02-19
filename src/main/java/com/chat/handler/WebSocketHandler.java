package com.chat.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private final static Logger log = LoggerFactory.getLogger(WebSocketHandler.class);
    private List<WebSocketSession> sessions = new ArrayList<>();

    // 소켓 커넥션 이후
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        log.info("enter : {}", session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for(WebSocketSession ws : sessions) {
            TextMessage msg = new TextMessage(message.getPayload());
            ws.sendMessage(msg);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        log.info("퇴장 : {]", session);
    }
}
