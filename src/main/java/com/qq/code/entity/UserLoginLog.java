package com.qq.code.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user_login_log")
public class UserLoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "ip_address", length = 20)
    private String ipAddress;

    @Column(name = "login_time")
    private Instant loginTime;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "update_at")
    private Instant updateAt;

}