package com.qq.code.service.Impl;

import com.qq.code.dto.SchoolDTO;
import com.qq.code.dto.UniversityDTO;
import com.qq.code.entity.InfoSchool;
import com.qq.code.entity.InfoUniversity;
import com.qq.code.entity.User;
import com.qq.code.entity.UserInfo;
import com.qq.code.enums.DegreeEnum;
import com.qq.code.enums.DepartmentEnum;
import com.qq.code.enums.SchoolLevelEnum;
import com.qq.code.enums.UniversityEnum;
import com.qq.code.repository.InfoSchoolRepository;
import com.qq.code.repository.InfoUniversityRepository;
import com.qq.code.service.SchoolService;
import com.qq.code.utils.AssertUtil;
import com.qq.code.utils.CurrentUserUtil;
import com.qq.code.utils.EnumUtil;
import com.qq.code.vo.SchoolVO;
import com.qq.code.vo.UniversityVO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private InfoUniversityRepository universityRepository;

    @Autowired
    private InfoSchoolRepository schoolRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UniversityDTO saveUniversity(UniversityVO universityVO) {
        InfoUniversity infoUniversity = modelMapper.map(universityVO, InfoUniversity.class);
        User user = CurrentUserUtil.getCurrentUser();
        infoUniversity.setUserId(user.getId());
        infoUniversity.setUpdateAt(LocalDateTime.now());
        universityRepository.save(infoUniversity);
        String university = EnumUtil.getByCode(UniversityEnum.class, universityVO.getUniversity()).getName();
        String department = EnumUtil.getByCode(DepartmentEnum.class, universityVO.getDepartment()).getName();
        String degree = EnumUtil.getByCode(DegreeEnum.class, universityVO.getDegree()).getName();
        UniversityDTO universityDTO = modelMapper.map(infoUniversity, UniversityDTO.class);
        universityDTO.setUniversity(university);
        universityDTO.setDepartment(department);
        universityDTO.setDegree(degree);
        universityDTO.setUpdateAt(LocalDateTime.now());
        return universityDTO;
    }

    @Override
    public SchoolDTO saveSchool(SchoolVO schoolVO) {
        InfoSchool infoSchool = modelMapper.map(schoolVO, InfoSchool.class);
        User user = CurrentUserUtil.getCurrentUser();
        infoSchool.setUserId(user.getId());
        schoolRepository.save(infoSchool);
        String schoolType = EnumUtil.getByCode(SchoolLevelEnum.class, schoolVO.getSchoolType()).getName();
        SchoolDTO schoolDTO = modelMapper.map(infoSchool, SchoolDTO.class);
        schoolDTO.setSchoolType(schoolType);
        schoolDTO.setUpdateAt(LocalDateTime.now());
        return schoolDTO;
    }
}
