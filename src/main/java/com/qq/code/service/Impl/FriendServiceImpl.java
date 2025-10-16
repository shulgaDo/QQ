package com.qq.code.service.Impl;

import com.qq.code.dto.FriendGroupDTO;
import com.qq.code.entity.UserFriend;
import com.qq.code.entity.UserInfo;
import com.qq.code.entity.UserStatus;
import com.qq.code.enums.UserStatusEnum;
import com.qq.code.repository.UserFriendRepository;
import com.qq.code.repository.UserInfoRepository;
import com.qq.code.repository.UserStatusRepository;
import com.qq.code.request.NewFriendGroupRequest;
import com.qq.code.service.FriendService;
import com.qq.code.utils.CurrentUserUtil;
import com.qq.code.utils.EnumUtil;
import com.qq.code.vo.FriendStatusVO;
import jakarta.transaction.Transactional;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {

    @Autowired
    private UserFriendRepository friendRepository;

    @Autowired
    private UserStatusRepository userStatusRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FriendStatusVO> getFriendStatus(Integer id) {
        List<UserFriend> userFriendList = friendRepository.findByGroupId(id);
        List<FriendStatusVO> listStatusVOs = userFriendList.stream()
                .map(friend -> {
                    Integer userStatus = userStatusRepository.findById(friend.getFriendId()).get().getUserStatus();
                    String userStatusName = EnumUtil.getByCode(UserStatusEnum.class, userStatus).getName();
                    UserInfo friendInfo = userInfoRepository.findById(friend.getUserId()).get();
                    FriendStatusVO friendStatusVO = modelMapper.map(friendInfo, FriendStatusVO.class);
                    friendStatusVO.setUserStatus(userStatusName);
                    return friendStatusVO;
                }).toList();
        return listStatusVOs;
    }

    @Override
    public FriendGroupDTO updateFriendGroup(NewFriendGroupRequest request) {
        Long friendId = request.getFriendId();
        Long userId = CurrentUserUtil.getCurrentUser().getId();
        UserFriend userFriend = friendRepository.findByUserIdAndFriendId(userId,friendId);
        userFriend.setGroupId(request.getGroupId());
        friendRepository.save(userFriend);
        FriendGroupDTO dto = modelMapper.map(userFriend, FriendGroupDTO.class);
        dto.setUpdateTime(LocalDateTime.now());
        return dto;
    }

    @Override
    public Map<String, List<FriendStatusVO>> getFriendStatusSortByInitial() {
        Long id = CurrentUserUtil.getCurrentUser().getId();
        List<UserFriend> userFriendList = friendRepository.findAllByUserId(id);
        Map<String, List<FriendStatusVO>> result = userFriendList.stream()
                .map(friend -> {
                    UserInfo userInfo = userInfoRepository.findById(friend.getFriendId()).get();
                    FriendStatusVO friendStatusVO = modelMapper.map(userInfo, FriendStatusVO.class);
                    Long userId = friend.getFriendId();
                    Optional<UserStatus> optionalUserStatus= userStatusRepository.findByUserId(userId);
                    Integer userStatus = optionalUserStatus.get().getUserStatus();
                    String status = EnumUtil.getByCode(UserStatusEnum.class, userStatus).getName();
                    friendStatusVO.setNickname(friend.getRemark());
                    friendStatusVO.setUserStatus(status);
                    return friendStatusVO;
                })
                .filter(vo -> vo.getNickname() != null && !vo.getNickname().isEmpty())
                .collect(Collectors.groupingBy(
                        vo -> {
                            String initial = getInitial(vo.getNickname());
                            return initial.matches("[A-Z]") ? initial : "#";
                        },
                        TreeMap::new,
                        Collectors.toList()
                ));
        return result;
    }

    private String getInitial(String nickname) {
        if (nickname == null || nickname.isEmpty()) {
            return "#";
        }
        char firstChar = nickname.trim().charAt(0);
        // 尝试中文转拼音
        try {
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(firstChar);
            if (pinyinArray != null && pinyinArray.length > 0) {
                // 去掉声调数字，例如 "liu2" → "liu"
                String pinyin = pinyinArray[0].replaceAll("[^a-zA-Z]", "");
                return pinyin.substring(0, 1).toUpperCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 其他情况
        return "#";
    }

    public static void main(String[] args) {
        char ch = '刘';
        String[] arr = PinyinHelper.toHanyuPinyinStringArray(ch);
        System.out.println(Arrays.toString(arr));
    }


}
