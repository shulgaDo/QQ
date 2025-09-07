package com.qq.code.controller;

import com.qq.code.common.ApiResponse;
import com.qq.code.dto.UserDTO;
import com.qq.code.vo.LoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "user Module", description = "User-related functions")
public class UserController {

    /**
     * 用户登陆
     * @param loginVO
     * @return
     */
    @PostMapping("/login")
    @Operation(summary = "user login",description = "user input account and password to login QQ")
    public ApiResponse<UserDTO> login(@Valid @RequestBody LoginVO loginVO){
        System.out.println("jjjj");
        return ApiResponse.success(null);
    }
}
