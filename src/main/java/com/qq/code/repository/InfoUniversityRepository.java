package com.qq.code.repository;

import com.qq.code.entity.InfoUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoUniversityRepository extends JpaRepository<InfoUniversity, Long> {
}