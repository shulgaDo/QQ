package com.qq.code.service.Impl;

import com.qq.code.repository.InfoPhotoRepository;
import com.qq.code.service.InfoPhotoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class InfoPhotoServiceImpl implements InfoPhotoService {

    @Autowired
    private InfoPhotoRepository infoPhotoRepository;

    @Override
    public List<String> findAll(Long userId) {
        return infoPhotoRepository.findAllByUserId(userId);
    }
}
