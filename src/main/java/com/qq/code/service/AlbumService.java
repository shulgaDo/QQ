package com.qq.code.service;

import com.qq.code.dto.AlbumDTO;
import com.qq.code.vo.AlbumVO;
import com.qq.code.vo.NewAlbumVO;

import java.util.List;

public interface AlbumService {
    List<AlbumVO> getAllAlbums();

    AlbumDTO createAlbum(NewAlbumVO newAlbumVO);
}
