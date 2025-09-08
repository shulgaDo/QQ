package com.qq.code.service;

import com.qq.code.dto.UserDTO;
import com.qq.code.vo.LoginVO;

public interface UserService {
    UserDTO login(LoginVO loginVO);
}
