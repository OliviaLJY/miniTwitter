package com.example.zhitongguigu.domain;

import java.util.Date;

public class TweetPost {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private Long id;
    private String title;
    private String Cotent;
    private Long AuthorId;
    private Date CreateTime;
    private String username;
    private Integer Likes;

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getLikes() {
        return Likes;
    }

    public void setLikes(Integer likes) {
        Likes = likes;
    }

    public Long getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Long authorId) {
        AuthorId = authorId;
    }

    public String getCotent() {
        return Cotent;
    }

    public void setCotent(String cotent) {
        Cotent = cotent;
    }
}
