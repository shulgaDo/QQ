package com.qq.code.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "album_photo")
public class AlbumPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @Column(name = "album_id")
//    private Long albumId;

    @Column(name = "upload_time")
    private LocalDate uploadTime;

    @Size(max = 255)
    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "create_at")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id",nullable = false)
    @JsonBackReference
    private UserAlbum userAlbum;

    public UserAlbum getUserAlbum() {
        return userAlbum;
    }

    public void setUserAlbum(UserAlbum userAlbum) {
        this.userAlbum = userAlbum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getAlbumId() {
//        return albumId;
//    }
//
//    public void setAlbumId(Long albumId) {
//        this.albumId = albumId;
//    }

    public LocalDate getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDate uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Column(name = "is_deleted")
    private Integer isDeleted;

}