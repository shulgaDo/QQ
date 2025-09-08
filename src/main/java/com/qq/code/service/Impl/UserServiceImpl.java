package com.qq.code.service.Impl;

import com.qq.code.common.ApiResponse;
import com.qq.code.common.UserContext;
import com.qq.code.dto.UserDTO;
import com.qq.code.entity.User;
import com.qq.code.repository.UserRepository;
import com.qq.code.service.UserService;
import com.qq.code.utils.AssertUtil;
import com.qq.code.utils.JWTUtil;
import com.qq.code.vo.LoginVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO login(LoginVO loginVO) {
        Optional<User> optionalUser = userRepository.findByUsername(loginVO.getAccount());
        AssertUtil.isError(optionalUser.isEmpty(),"账号不存在！");
        User user = optionalUser.get();
        boolean isUser = passwordEncoder.matches(loginVO.getPassword(), user.getPassword());
        AssertUtil.isError(!isUser,"账号或者密码错误！");
        String token = jwtUtil.generateToken(loginVO.getAccount());
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setLoginAt(LocalDateTime.now());
        userDTO.setToken(token);
        UserContext.setUser(user);
        return userDTO;
    }
}
