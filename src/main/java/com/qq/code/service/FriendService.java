package com.qq.code.service;

import com.qq.code.dto.FriendGroupDTO;
import com.qq.code.request.NewFriendGroupRequest;
import com.qq.code.vo.FriendStatusVO;

import java.util.List;
import java.util.Map;

public interface FriendService {
    List<FriendStatusVO> getFriendStatus(Integer id);

    FriendGroupDTO updateFriendGroup(NewFriendGroupRequest request);

    Map<String, List<FriendStatusVO>> getFriendStatusSortByInitial();

    int deleteFriend(Long friendId);
}
