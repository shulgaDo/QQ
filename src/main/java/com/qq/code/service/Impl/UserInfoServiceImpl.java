package com.qq.code.service.Impl;

import com.qq.code.common.UserContext;
import com.qq.code.dto.UserInfoDTO;
import com.qq.code.entity.User;
import com.qq.code.entity.UserInfo;
import com.qq.code.enums.GenderEnum;
import com.qq.code.enums.JobEnum;
import com.qq.code.repository.UserInfoRepository;
import com.qq.code.service.InfoPhotoService;
import com.qq.code.service.UserInfoService;
import com.qq.code.utils.AssertUtil;
import com.qq.code.utils.BeanCopyUtil;
import com.qq.code.utils.CurrentUserUtil;
import com.qq.code.utils.ZodiacUtil;
import com.qq.code.vo.CoverInfoVO;
import com.qq.code.vo.StatusInfoVO;
import com.qq.code.vo.UserInfoVO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private InfoPhotoService infoPhotoService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CoverInfoVO getCoverInfo() {

        //TODO 这里coverImg和likes由于表没有设计所以都为null
        //TODO status设计
        UserInfo userInfo = showUserInfo();
        List<String> photos = infoPhotoService.findAll(userInfo.getUserId());
        CoverInfoVO coverInfoVO = modelMapper.map(userInfo, CoverInfoVO.class);
        String gender = GenderEnum.toGender(userInfo.getGender());
        Integer day = userInfo.getBirthDay();
        Integer month = userInfo.getBirthMonth();
        String zodiac = ZodiacUtil.getZodiac(month, day);
        coverInfoVO.setGender(gender);
        coverInfoVO.setBirthDay(day);
        coverInfoVO.setBirthMonth(month);
        coverInfoVO.setZodiacSign(zodiac);
        coverInfoVO.setPhotos(photos);
        return coverInfoVO;
    }

    @Override
    public UserInfoVO getUserInfo() {
        UserInfo userInfo = showUserInfo();
        UserInfoVO userInfoVO = modelMapper.map(userInfo, UserInfoVO.class);
        List<String> photos = infoPhotoService.findAll(userInfo.getUserId());
        Integer job = userInfo.getJob();
        String jobM = JobEnum.fromCodeToJob(job);
        userInfoVO.setGender(GenderEnum.toGender(userInfo.getGender()));
        userInfoVO.setJob(jobM);
        userInfoVO.setPhotosNumber(photos.size());
        return userInfoVO;
    }

    @Override
    public UserInfoDTO updateUserInfo(UserInfoVO userInfoVO) {
        UserInfo userInfo = showUserInfo();
        BeanCopyUtil.copyNonNullProperties(userInfoVO,userInfo);
        UserInfo info = userInfoRepository.save(userInfo);
        UserInfoDTO userInfoDTO = modelMapper.map(info, UserInfoDTO.class);
        return userInfoDTO;
    }

    @Override
    public StatusInfoVO getStatusInfo() {
        UserInfo userInfo = showUserInfo();
        User user = CurrentUserUtil.getCurrentUser();
        StatusInfoVO statusInfoVO = modelMapper.map(userInfo, StatusInfoVO.class);
        Instant createdAt   = user.getCreatedAt();
        LocalDate loginDay = createdAt.atZone(ZoneId.systemDefault()).toLocalDate();
        int day =(int) ChronoUnit.DAYS.between(loginDay, LocalDate.now());
        int rank = day / 20;
        statusInfoVO.setRank(rank);
        return statusInfoVO;
    }

    private UserInfo showUserInfo(){
        User user = CurrentUserUtil.getCurrentUser();
        Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(user.getId());
        AssertUtil.isError(optionalUserInfo.isEmpty(),"id找不到，快去查查问题");
        return optionalUserInfo.get();
    }
}
