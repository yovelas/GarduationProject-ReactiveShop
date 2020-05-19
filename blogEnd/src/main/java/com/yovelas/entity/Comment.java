package com.yovelas.entity;

public class Comment {
    private int id;
    private String articleId;
    private String email;
    private String comments;
    private int status;
    private String createTime;

    public Comment(int id, String articleId, String email, String comments, int status, String createTime) {
        this.id = id;
        this.articleId = articleId;
        this.email = email;
        this.comments = comments;
        this.status = status;
        this.createTime = createTime;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", articleId='" + articleId + '\'' +
                ", email='" + email + '\'' +
                ", comments='" + comments + '\'' +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
