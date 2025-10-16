package com.qq.code.service.Impl;

import com.qq.code.entity.User;
import com.qq.code.entity.UserInfo;
import com.qq.code.repository.UserInfoRepository;
import com.qq.code.repository.UserRepository;
import com.qq.code.service.SearchService;
import com.qq.code.utils.ZodiacUtil;
import com.qq.code.vo.NewFriendVO;
import com.qq.code.vo.SearchFriendVO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository infoRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SearchFriendVO findFriendByAccount(String account) {
        Optional<UserInfo> userInfo = infoRepository.findByAccount(account);
        if(userInfo.isEmpty()){
            return null;
        }
        UserInfo u = userInfo.get();
        SearchFriendVO vo = modelMapper.map(u, SearchFriendVO.class);
        return vo;
    }

    @Override
    public List<NewFriendVO> findFriendByNickname(String nickname) {
        List<UserInfo> userInfoList = infoRepository.findByNicknameLike("%" + nickname + "%");
        List<NewFriendVO> vos = userInfoList.stream()
                .map(info -> {
                    NewFriendVO vo = modelMapper.map(info, NewFriendVO.class);
                    LocalDate birthday = LocalDate.of(info.getBirthYear(), info.getBirthMonth(), info.getBirthDay());
                    int age = Period.between(birthday, LocalDate.now()).getYears();
                    int month = info.getBirthMonth();
                    int day = info.getBirthDay();
                    String zodiac = ZodiacUtil.getZodiac(month, day);
                    vo.setAge(age);
                    vo.setZodiac(zodiac);
                    return vo;
                }).toList();
        return vos;
    }
}
