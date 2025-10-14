package com.qq.code.repository;

import com.qq.code.entity.AlbumPhoto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumPhotoRepository extends JpaRepository<AlbumPhoto, Long> {
    List<AlbumPhoto> findAllByAlbumId(Long id);

    @Query(value = "SELECT * FROM album_photo\n" +
            "WHERE album_id = :albumId AND is_deleted = 1",nativeQuery = true)
    List<AlbumPhoto> findByAlbumIdAndIsDeleted(@Param(value = "albumId") Long albumId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM album_photo a\n" +
            "WHERE a.id IN :ids",nativeQuery = true)
    int deleteByIds(@Param(value = "ids") List<Long> ids);
}