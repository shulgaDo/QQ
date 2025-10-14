package com.qq.code.repository;

import com.qq.code.entity.AlbumRecycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRecycleRepository extends JpaRepository<AlbumRecycle, Long> {
}