package com.qq.code.service;

import com.qq.code.dto.SchoolDTO;
import com.qq.code.dto.UniversityDTO;
import com.qq.code.vo.SchoolVO;
import com.qq.code.vo.UniversityVO;

public interface SchoolService {

    UniversityDTO saveUniversity(UniversityVO universityVO);

    SchoolDTO saveSchool(SchoolVO schoolVO);
}
