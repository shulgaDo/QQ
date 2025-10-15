package com.qq.code.service;

import com.qq.code.dto.AlbumDTO;
import com.qq.code.dto.PhotosStatusDTO;
import com.qq.code.request.AlbumCommentRequest;
import com.qq.code.vo.*;

import java.util.List;
import java.util.Map;

public interface AlbumService {
    List<AlbumVO> getAllAlbums();

    AlbumDTO createAlbum(NewAlbumVO newAlbumVO);

    Map<String, List<PhotoVO>> getPhotosByAlbumId(Long id);

    List<PhotosStatusDTO> deletePhotos(List<Long> ids);

    List<RecyclePhotoVO> loginRecycle(String password);

    int deleteRecyclePhotos(List<Long> ids);

    List<PhotosStatusDTO> restoreRecycle(List<Long> ids);

    AlbumCommentVO addAlbumComment(AlbumCommentRequest albumComment);

    List<AlbumCommentVO> getAlbumComment(Long albumId);

    int deleteAlbumComment(Long commentId);
}
