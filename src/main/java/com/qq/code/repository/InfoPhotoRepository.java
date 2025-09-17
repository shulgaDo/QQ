package com.qq.code.repository;

import com.qq.code.entity.InfoPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoPhotoRepository extends JpaRepository<InfoPhoto, Long>, JpaSpecificationExecutor<InfoPhoto> {

    @Query(value = "SELECT photo_url\n" +
            "FROM info_photo\n" +
            "WHERE user_id = :userId",nativeQuery = true)
    List<String> findAllByUserId(@Param(value = "userId") Long userId);
}