package com.chat.controller;

import com.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final static Logger logger = LoggerFactory.getLogger(ChatService.class);
    private final ChatService chatService;

    // 채팅방 생성
    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public ResponseEntity createChatRoom() {
        int result = chatService.createChatRoom();
        return new ResponseEntity(HttpStatus.OK);
    }

    // 채팅방 리스트 조회
}
