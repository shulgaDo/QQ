package com.qq.code.repository;

import com.qq.code.entity.UserAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAlbumRepository extends JpaRepository<UserAlbum, Long> {
    List<UserAlbum> findAllByUserId(Long id);
}