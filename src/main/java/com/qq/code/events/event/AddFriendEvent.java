package com.qq.code.events.event;

import com.qq.code.vo.AddFriendApplyVO;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class AddFriendEvent extends ApplicationEvent {

    private AddFriendApplyVO addFriendApplyVO;

    public AddFriendEvent(Object source) {
        super(source);
    }

    public AddFriendEvent(Object source,AddFriendApplyVO addFriendApplyVO){
        super(source);
        this.addFriendApplyVO = addFriendApplyVO;
    }

    public AddFriendApplyVO getAddFriendApplyVO() {
        return addFriendApplyVO;
    }

    public void setAddFriendApplyVO(AddFriendApplyVO addFriendApplyVO) {
        this.addFriendApplyVO = addFriendApplyVO;
    }
}
