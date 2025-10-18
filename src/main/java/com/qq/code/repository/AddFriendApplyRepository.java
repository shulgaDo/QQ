package com.qq.code.repository;

import com.qq.code.entity.AddFriendApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddFriendApplyRepository extends JpaRepository<AddFriendApply, Long> {
}