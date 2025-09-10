package com.qq.code.repository;

import com.qq.code.entity.InfoPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoPhotoRepository extends JpaRepository<InfoPhoto, Long>, JpaSpecificationExecutor<InfoPhoto> {
}