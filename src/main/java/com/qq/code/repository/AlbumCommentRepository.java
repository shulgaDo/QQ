package com.qq.code.repository;

import com.qq.code.entity.AlbumComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumCommentRepository extends JpaRepository<AlbumComment, Long> {
    List<AlbumComment> findAllByAlbumId(Long albumId);
}