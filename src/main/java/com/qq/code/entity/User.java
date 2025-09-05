package com.qq.code.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "account", nullable = false, length = 30)
    private String account;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "is_lock")
    private Boolean isLock;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "update_at")
    private Instant updateAt;

}