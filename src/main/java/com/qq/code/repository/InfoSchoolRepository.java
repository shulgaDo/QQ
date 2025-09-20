package com.qq.code.repository;

import com.qq.code.entity.InfoSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoSchoolRepository extends JpaRepository<InfoSchool, Long> {
}