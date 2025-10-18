package com.qq.code.events.listen;

import com.qq.code.events.event.AddFriendEvent;
import com.qq.code.handler.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AddFriendListener {

    @Autowired
    private WebSocketHandler webSocketHandler;

    @Async
    @EventListener
    public void onFriendRequest(AddFriendEvent event){
        String message = "用户：" + event.getAddFriendApplyVO().getAccount() + " 好友申请：" +event.getAddFriendApplyVO().getMessage();
        webSocketHandler.sendToUser(Long.valueOf(event.getAddFriendApplyVO().getAccount()),message);
    }
}
