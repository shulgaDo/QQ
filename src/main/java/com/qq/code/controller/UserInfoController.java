package com.qq.code.controller;

import com.google.protobuf.Api;
import com.qq.code.common.ApiResponse;
import com.qq.code.dto.SchoolDTO;
import com.qq.code.dto.UniversityDTO;
import com.qq.code.dto.UserInfoDTO;
import com.qq.code.service.InfoPhotoService;
import com.qq.code.service.SchoolService;
import com.qq.code.service.UserInfoService;
import com.qq.code.vo.*;
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

    @Autowired
    private SchoolService schoolService;

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
     * 点击显示左侧用户状态信息
     * @return
     */
    @Operation(summary = "left status info",description = "click left show user status info")
    @GetMapping("/show/status")
    public ApiResponse<StatusInfoVO>  statusInfo(){
        StatusInfoVO statusInfoVO = userInfoService.getStatusInfo();
        return ApiResponse.success(statusInfoVO);
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

    /**
     * 添加大学
     * @param universityVO
     * @return
     */
   @Operation(summary = "add university",description = "user save university information")
   @PostMapping("/university")
    public ApiResponse saveUniversity(@RequestBody @Valid UniversityVO universityVO){
        UniversityDTO universityDTO = schoolService.saveUniversity(universityVO);
        return ApiResponse.success(universityDTO);
    }

    /**
     * 添加中学或者小学
     * @param schoolVO
     * @return
     */
    @Operation(summary = "save school", description = "user save school")
    @PostMapping("/school")
    public ApiResponse saveSchool(@RequestBody @Valid SchoolVO schoolVO){
        SchoolDTO schoolDTO = schoolService.saveSchool(schoolVO);
        return ApiResponse.success(schoolDTO);
    }
}
