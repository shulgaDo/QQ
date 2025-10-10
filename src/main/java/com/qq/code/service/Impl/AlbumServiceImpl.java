package com.qq.code.service.Impl;

import com.qq.code.dto.AlbumDTO;
import com.qq.code.repository.AlbumPhotoRepository;
import com.qq.code.repository.UserAlbumRepository;
import com.qq.code.service.AlbumService;
import com.qq.code.vo.AlbumVO;
import com.qq.code.vo.NewAlbumVO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private UserAlbumRepository userAlbumRepository;

    @Autowired
    private AlbumPhotoRepository albumPhotoRepository;

    @Override
    public List<AlbumVO> getAllAlbums() {
        return null;
    }

    @Override
    public AlbumDTO createAlbum(NewAlbumVO newAlbumVO) {
        return null;
    }
}
