package kz.iitu.edu.model;

import java.util.Date;
import java.util.List;

public class Post implements java.io.Serializable {
    private Integer id;
    private String content;
    private Date publishedDate;
    private Integer userId;
    private User user;
    private List<Comments> comments;

    public Post() {
    }

    public Post(Integer id, String content, Date publishedDate, Integer userId, User user) {
        this.id = id;
        this.content = content;
        this.publishedDate = publishedDate;
        this.userId = userId;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
