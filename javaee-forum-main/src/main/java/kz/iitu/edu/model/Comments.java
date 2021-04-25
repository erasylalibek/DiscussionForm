package kz.iitu.edu.model;

import java.sql.Date;

public class Comments implements java.io.Serializable {

    private Integer id;
    private Integer likes;
    private Integer postId;
    private Integer userId;
    private String content;
    private Date publishedDate;
    private User user;

    public Comments(Integer id, Integer likes, Integer postId,
                    Integer userId, String content, Date publishedDate, User user) {
        this.id = id;
        this.likes = likes;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.publishedDate = publishedDate;
        this.user = user;
    }

    public Comments() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
