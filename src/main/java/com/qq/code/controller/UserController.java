package com.qq.code.controller;

import com.qq.code.common.ApiResponse;
import com.qq.code.common.UserContext;
import com.qq.code.dto.UserDTO;
import com.qq.code.service.UserService;
import com.qq.code.vo.LoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "user Module", description = "User-related functions")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登陆
     * @param loginVO
     * @return
     */
    @PostMapping("/login")
    @Operation(summary = "user login",description = "user input account and password to login QQ")
    public ApiResponse<UserDTO> login(@Valid @RequestBody LoginVO loginVO){
        UserDTO userDTO = userService.login(loginVO);
        return ApiResponse.success(userDTO);
    }

    /**
     * 用户登出
     * @return
     */
    @GetMapping("/logout")
    @Operation(summary = "User logout")
    public ApiResponse logout(){
        UserContext.clear();
        return ApiResponse.success("User logout successful !");
    }
}
