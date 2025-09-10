package com.qq.code.controller;

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

    }

    /**
     * 用户封面信息
     * @return
     */
    @Operation(summary = "show user cover info",description = "show user's cover personal inforamtion")
    @GetMapping("/show/cover")
    public ApiResponse<CoverInfoVO> coverInfo(){

    }

    /**
     * 编辑资料
      * @param userInfoVO
     * @return
     */
    @Operation(summary = "update user information",description = "update user information")
    @PostMapping("/update")
    public ApiResponse<UserInfoDTO> update(@RequestBody @Valid UserInfoVO userInfoVO){

    }

}
