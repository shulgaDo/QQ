package com.qq.code.service.Impl;

import com.qq.code.common.ApiResponse;
import com.qq.code.common.UserContext;
import com.qq.code.dto.UserDTO;
import com.qq.code.entity.User;
import com.qq.code.entity.UserLoginLog;
import com.qq.code.repository.UserLoginLogRepository;
import com.qq.code.repository.UserRepository;
import com.qq.code.service.UserService;
import com.qq.code.utils.AssertUtil;
import com.qq.code.utils.IPUtil;
import com.qq.code.utils.JWTUtil;
import com.qq.code.vo.LoginVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoginLogRepository userLoginLogRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO login(LoginVO loginVO,HttpServletRequest request) {
        Optional<User> optionalUser = userRepository.findByUsername(loginVO.getAccount());
        UserLoginLog loginLog = new UserLoginLog();
        AssertUtil.isError(optionalUser.isEmpty(),"账号不存在！");
        User user = optionalUser.get();
        boolean isUser = passwordEncoder.matches(loginVO.getPassword(), user.getPassword());
        AssertUtil.isError(!isUser,"账号或者密码错误！");
        //记录用户登陆日志
        loginLog.setUserId(user.getId());
        loginLog.setLoginTime(LocalDateTime.now());
        String ip = IPUtil.getClientIp(request);
        loginLog.setIpAddress(ip);
        userLoginLogRepository.save(loginLog);
        String token = jwtUtil.generateToken(loginVO.getAccount());
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setLoginAt(LocalDateTime.now());
        userDTO.setToken(token);
        UserContext.setUser(user);
        return userDTO;
    }


}
