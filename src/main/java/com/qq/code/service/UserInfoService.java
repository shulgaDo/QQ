package com.qq.code.service;

import com.qq.code.dto.UserInfoDTO;
import com.qq.code.vo.CoverInfoVO;
import com.qq.code.vo.UserInfoVO;

public interface UserInfoService {
    CoverInfoVO getCoverInfo();         //显示封面信息

    UserInfoVO getUserInfo();

    UserInfoDTO updateUserInfo(UserInfoVO userInfoVO);
}
