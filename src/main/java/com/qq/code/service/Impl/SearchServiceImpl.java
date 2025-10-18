package com.qq.code.service.Impl;

import com.qq.code.dto.AddFriendApplyDTO;
import com.qq.code.entity.AddFriendApply;
import com.qq.code.entity.User;
import com.qq.code.entity.UserInfo;
import com.qq.code.events.event.AddFriendEvent;
import com.qq.code.repository.AddFriendApplyRepository;
import com.qq.code.repository.UserInfoRepository;
import com.qq.code.repository.UserRepository;
import com.qq.code.service.SearchService;
import com.qq.code.utils.CurrentUserUtil;
import com.qq.code.utils.ZodiacUtil;
import com.qq.code.vo.AddFriendApplyVO;
import com.qq.code.vo.NewFriendVO;
import com.qq.code.vo.SearchFriendVO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
    private UserInfoRepository infoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private AddFriendApplyRepository applyRepository;

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

    @Override
    public AddFriendApplyDTO addFriend(AddFriendApplyVO addFriendApplyVO) {
        AddFriendApply apply = modelMapper.map(addFriendApplyVO, AddFriendApply.class);
        String userAccount = CurrentUserUtil.getCurrentUser().getAccount();
        apply.setUserAccount(userAccount);
        apply.setFriendAccount(addFriendApplyVO.getAccount());
        apply.setFriendGroup(addFriendApplyVO.getGroupId());
        AddFriendApplyDTO dto = modelMapper.map(addFriendApplyVO, AddFriendApplyDTO.class);
        dto.setCreateAt(LocalDateTime.now());
        applyRepository.save(apply);
        publisher.publishEvent(new AddFriendEvent(this,addFriendApplyVO));
        return dto;
    }
}
