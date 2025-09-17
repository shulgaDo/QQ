package com.qq.code.controller;

import com.google.protobuf.Api;
import com.qq.code.common.ApiResponse;
import com.qq.code.dto.UserInfoDTO;
import com.qq.code.service.InfoPhotoService;
import com.qq.code.service.UserInfoService;
import com.qq.code.vo.CoverInfoVO;
import com.qq.code.vo.UserInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "user information module",description = "Is abut user's information API")
@RestController
@RequestMapping("/api/info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    /**
     * 用户信息
     * @return
     */
    @Operation(summary = "show user information",description = "user click update information button,and show user info")
    @GetMapping("/show")
    public ApiResponse<UserInfoVO> info(){
        UserInfoVO userInfoVO = userInfoService.getUserInfo();
        return ApiResponse.success(userInfoVO);
    }

    /**
     * 用户封面信息
     * @return
     */
    @Operation(summary = "show user cover info",description = "show user's cover personal inforamtion")
    @GetMapping("/show/cover")
    public ApiResponse<CoverInfoVO> coverInfo(){
        CoverInfoVO coverInfoVO = userInfoService.getCoverInfo();
        return ApiResponse.success(coverInfoVO);
    }

    /**
     * 编辑资料
      * @param userInfoVO
     * @return
     */
    @Operation(summary = "update user information",description = "update user information")
    @PatchMapping("/update")
    public ApiResponse<UserInfoDTO> updateUserInfo(@RequestBody @Valid UserInfoVO userInfoVO){
        UserInfoDTO userInfoDTO = userInfoService.updateUserInfo(userInfoVO);
        return ApiResponse.success(userInfoDTO);
    }

    //TODO 添加大学

    //TODO 添加中学或小学

}
