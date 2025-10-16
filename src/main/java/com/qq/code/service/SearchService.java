package com.qq.code.service;

import com.qq.code.vo.NewFriendVO;
import com.qq.code.vo.SearchFriendVO;

import java.util.List;

public interface SearchService {
    SearchFriendVO findFriendByAccount(String account);

    List<NewFriendVO> findFriendByNickname(String nickname);
}
