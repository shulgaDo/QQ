package com.qq.code.controller;

import com.qq.code.common.ApiResponse;
import com.qq.code.service.SearchService;
import com.qq.code.vo.NewFriendVO;
import com.qq.code.vo.SearchFriendVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "about search API" , description = "search user,account and other information API")
@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    /**
     * 通过账号搜索好友
     * @param account
     * @return
     */
    @Operation(summary = "search friend by account",description = "find friend by account")
    @PostMapping("/account")
    public ApiResponse<SearchFriendVO> findFriend(@RequestParam String account){
       SearchFriendVO vo = searchService.findFriendByAccount(account);
       return ApiResponse.success(vo);
    }

    /**
     * 通过昵称搜索好友
     * @param nickname
     * @return
     */
    @Operation(summary = "search friend by nickname",description = "find user by nickname")
    @PostMapping("/nickname")
    public ApiResponse<List<NewFriendVO>> searchFriend(@RequestParam String nickname){
        List<NewFriendVO> newFriendVOS = searchService.findFriendByNickname(nickname);
        return ApiResponse.success(newFriendVOS);
    }

}
