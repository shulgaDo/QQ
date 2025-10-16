package com.qq.code.controller;

import com.google.protobuf.Api;
import com.qq.code.common.ApiResponse;
import com.qq.code.dto.FriendGroupDTO;
import com.qq.code.request.NewFriendGroupRequest;
import com.qq.code.service.FriendService;
import com.qq.code.vo.FriendStatusVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "好友列表",description = "好友列表")
@RestController
@RequestMapping("/api/friends")
public class FriendsController {

    @Autowired
    private FriendService friendService;

    /**
     * 查看分组好友
      * @param id
     * @return
     */
    @Operation(summary = "show friend status",description = "show friends status click the group")
    @GetMapping("/group/{id}")
    public ApiResponse<List<FriendStatusVO>> getFriendStatus(@PathVariable Integer id){
        List<FriendStatusVO>  statusVOList = friendService.getFriendStatus(id);
        return ApiResponse.success(statusVOList);
    }

    /**
     * 修改好友分组状态
      * @param request
     * @return
     */
   @Operation(summary = "update friend group",description = "update friend group status")
   @PatchMapping("/group/update")
    public ApiResponse<FriendGroupDTO> updateFriendGroup(@RequestBody NewFriendGroupRequest request){
        FriendGroupDTO friendGroupDTO = friendService.updateFriendGroup(request);
        return ApiResponse.success(friendGroupDTO);
    }

    /**
     * 所以好友按首字母排序
     * @return
     */
    @Operation(summary = "select friend sort by initial",description = "click button to find friend sort by initial")
    @GetMapping("/sort/initial")
    public ApiResponse<Map<String,List<FriendStatusVO>>> getFriendStatusSortByInitial(){
        Map<String,List<FriendStatusVO>> vo = friendService.getFriendStatusSortByInitial();
        return ApiResponse.success(vo);
    }


}
