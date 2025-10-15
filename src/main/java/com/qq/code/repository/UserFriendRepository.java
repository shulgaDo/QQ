package com.qq.code.repository;

import com.qq.code.entity.UserFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFriendRepository extends JpaRepository<UserFriend, Long> {

    @Query(value = "SELECT *\n" +
            "FROM user_friends\n" +
            "WHERE group_id = :groupId",nativeQuery = true)
    List<UserFriend> findByGroupId(@Param(value = "groupId") Integer groupId);

    UserFriend findByUserIdAndFriendId(Long userId, Long friendId);

    @Query(value = "SELECT * \n" +
            "FROM user_friends\n" +
            "WHERE user_id = :id",nativeQuery = true)
    List<UserFriend> findAllByUserId(@Param(value = "id") Long id);
}