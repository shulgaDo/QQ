package com.qq.code.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private static final Map<Long, WebSocketSession> SESSIONS = new ConcurrentHashMap<>();

    private Long extractUserId(WebSocketSession session){
        String path = session.getUri().getPath();
        try {
            return Long.valueOf(path.substring(path.lastIndexOf('/')+1));
        }catch (Exception e){
            return null;
        }
    }

    public void sendToUser(Long userId,String message){
        WebSocketSession session = SESSIONS.get(userId);
        if(session != null && session.isOpen()){
            try {
                session.sendMessage(new TextMessage(message));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Long userId = extractUserId(session);
        if(userId != null){
            SESSIONS.put(userId,session);
            System.out.println("用户上线："+userId);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Long userId = extractUserId(session);
        if(userId != null){
            SESSIONS.remove(userId);
            System.out.println("用户下线："+userId);
        }
    }
}
