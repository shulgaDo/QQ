package com.qq.code.repository;

import com.qq.code.entity.UserLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginLogRepository extends JpaRepository<UserLoginLog, Long> {
}