package com.qq.code.repository;

import com.qq.code.entity.User;
import com.qq.code.vo.LoginVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select *\n" +
            "from `user`\n" +
            "where account = :username",nativeQuery = true)
   Optional<User> findByUsername(@Param(value = "username") String username);
}