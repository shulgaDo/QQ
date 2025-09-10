package com.qq.code.service;

import com.qq.code.dto.UserDTO;
import com.qq.code.vo.LoginVO;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    UserDTO login(LoginVO loginVO, HttpServletRequest request);
}
