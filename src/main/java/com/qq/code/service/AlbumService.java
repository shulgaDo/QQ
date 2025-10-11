package com.qq.code.service;

import com.qq.code.dto.AlbumDTO;
import com.qq.code.vo.AlbumVO;
import com.qq.code.vo.NewAlbumVO;
import com.qq.code.vo.PhotoVO;

import java.util.List;
import java.util.Map;

public interface AlbumService {
    List<AlbumVO> getAllAlbums();

    AlbumDTO createAlbum(NewAlbumVO newAlbumVO);

    Map<String, List<PhotoVO>> getPhotosByAlbumId(Long id);
}
