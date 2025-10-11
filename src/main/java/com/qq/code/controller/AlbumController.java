package com.qq.code.controller;

import com.qq.code.common.ApiResponse;
import com.qq.code.dto.AlbumDTO;
import com.qq.code.service.AlbumService;
import com.qq.code.vo.AlbumVO;
import com.qq.code.vo.NewAlbumVO;
import com.qq.code.vo.PhotoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Album module",description = "Is about the album API")
@RestController
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    /**
     * 展示所有相册
      * @return
     */
    @Operation(summary = "show album photos",description = "click 'album' button show all albumVO")
    @GetMapping("/show")
    public ApiResponse<List<AlbumVO>> getAllAlbum(){
        List<AlbumVO> albumVOS = albumService.getAllAlbums();
        return ApiResponse.success(albumVOS);
    }

    /**
     * 新建相册
      * @param newAlbumVO
     * @return
     */
    @Operation(summary = "create new album",description = "click 'create' create new album")
    @PostMapping("/add")
    public ApiResponse<AlbumDTO> createAlbum(@Valid @RequestBody NewAlbumVO newAlbumVO){
        AlbumDTO albumDTO = albumService.createAlbum(newAlbumVO);
        return ApiResponse.success(albumDTO);
    }

    /**
     * 点击展示相册
     * @param id
     * @return
     */
    @Operation(summary = "show album photo",description = "show user album photos")
    @GetMapping("/show/{id}")
    public ApiResponse<Map<String,List<PhotoVO>>> getPhotos(@PathVariable Long id){
        Map<String,List<PhotoVO>> photos = albumService.getPhotosByAlbumId(id);
        return ApiResponse.success(photos);
    }


}
