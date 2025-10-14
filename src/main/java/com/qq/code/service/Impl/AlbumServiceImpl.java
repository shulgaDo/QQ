package com.qq.code.service.Impl;

import com.qq.code.dto.AlbumDTO;
import com.qq.code.dto.PhotosStatusDTO;
import com.qq.code.entity.AlbumPhoto;
import com.qq.code.entity.User;
import com.qq.code.entity.UserAlbum;
import com.qq.code.enums.AlbumPermissEnum;
import com.qq.code.repository.AlbumPhotoRepository;
import com.qq.code.repository.AlbumRecycleRepository;
import com.qq.code.repository.UserAlbumRepository;
import com.qq.code.service.AlbumService;
import com.qq.code.utils.AssertUtil;
import com.qq.code.utils.CurrentUserUtil;
import com.qq.code.utils.EnumUtil;
import com.qq.code.vo.AlbumVO;
import com.qq.code.vo.NewAlbumVO;
import com.qq.code.vo.PhotoVO;
import com.qq.code.vo.RecyclePhotoVO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private UserAlbumRepository userAlbumRepository;

    @Autowired
    private AlbumPhotoRepository albumPhotoRepository;

    @Autowired
    private AlbumRecycleRepository recycleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AlbumVO> getAllAlbums() {
        User user = CurrentUserUtil.getCurrentUser();
        List<UserAlbum> albumList = userAlbumRepository.findAllByUserId(user.getId());
        List<AlbumVO> listAlbumVO = albumList.stream()
                .map(album -> {
                    AlbumVO albumVO = new AlbumVO();
                    albumVO.setAlbumDescribe(album.getAlbumDescribe());
                    albumVO.setAlbumNum(album.getAlbumNum());
                    Integer albumStatus = album.getAlbumStatus();
                    String permission = EnumUtil.getByCode(AlbumPermissEnum.class, albumStatus).getName();
                    albumVO.setPermission(permission);
                    return albumVO;
                }).toList();
        return listAlbumVO;
    }

    @Override
    public AlbumDTO createAlbum(NewAlbumVO newAlbumVO) {
        Long id = CurrentUserUtil.getCurrentUser().getId();
        UserAlbum userAlbum = modelMapper.map(newAlbumVO, UserAlbum.class);
        userAlbum.setUserId(id);
        userAlbum.setCreateAt(LocalDateTime.now());
        userAlbumRepository.save(userAlbum);
        AlbumDTO albumDTO = modelMapper.map(newAlbumVO, AlbumDTO.class);
        albumDTO.setCreateTime(LocalDateTime.now());
        return albumDTO;
    }

    @Override
    public Map<String, List<PhotoVO>> getPhotosByAlbumId(Long id) {
        List<AlbumPhoto> albumPhotos = albumPhotoRepository.findAllByAlbumId(id);
        List<PhotoVO> listPhotoVO = albumPhotos.stream()
                .map(photo -> modelMapper.map(photo, PhotoVO.class)).toList();
        return listPhotoVO.stream()
                .collect(Collectors.groupingBy(photo -> photo.getUploadTime().toString()));
    }

    @Override
    public List<PhotosStatusDTO> deletePhotos(List<Long> ids) {
        List<AlbumPhoto> photos = albumPhotoRepository.findAllById(ids);
        List<AlbumPhoto> albumPhotos = photos.stream()
                .peek(photo -> photo.setIsDeleted(1)).toList();
        albumPhotoRepository.saveAll(albumPhotos);
        List<PhotosStatusDTO> photoStatusDTO = albumPhotos.stream()
                .map(photo -> {
                    PhotosStatusDTO dto = modelMapper.map(photo, PhotosStatusDTO.class);
                    dto.setDeletedTime(LocalDateTime.now());
                    return dto;
                }).toList();
        return photoStatusDTO;
    }

    @Override
    public List<RecyclePhotoVO> loginRecycle(String password) {
        Long id = CurrentUserUtil.getCurrentUser().getId();
        String pwd = recycleRepository.findById(id).get().getPassword();
        if(!password.equals(pwd)){
            AssertUtil.isError(true,"密码出错了！");
        }
        List<UserAlbum> userAlbum = userAlbumRepository.findAllByUserId(id);
        List<AlbumPhoto> albumPhotoList = userAlbum.stream()
                .map(album -> {
                    Long albumId = album.getId();
                    List<AlbumPhoto> albumPhotos = albumPhotoRepository.findByAlbumIdAndIsDeleted(albumId);
                    return albumPhotos;
                }).flatMap(List::stream)
                .toList();
        List<RecyclePhotoVO> recyclePhotoVOs = albumPhotoList.stream()
                .map(albumPhoto -> {
                    RecyclePhotoVO recyclePhotoVO = modelMapper.map(albumPhoto, RecyclePhotoVO.class);
                    recyclePhotoVO.setDeletedTime(LocalDateTime.now());
                    return recyclePhotoVO;
                }).toList();
        return recyclePhotoVOs;
    }

    @Override
    public int deleteRecyclePhotos(List<Long> ids) {
        return albumPhotoRepository.deleteByIds(ids);
    }

    @Override
    public List<PhotosStatusDTO> restoreRecycle(List<Long> ids) {
        List<AlbumPhoto> photos = albumPhotoRepository.findAllById(ids);
        List<AlbumPhoto> albumPhotos = photos.stream()
                .peek(photo -> photo.setIsDeleted(0)).toList();
        albumPhotoRepository.saveAll(albumPhotos);
        List<PhotosStatusDTO> photoStatusDTO = albumPhotos.stream()
                .map(photo -> {
                    return modelMapper.map(photo, PhotosStatusDTO.class);
                }).toList();
        return photoStatusDTO;
    }
}
