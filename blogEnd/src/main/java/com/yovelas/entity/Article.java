package com.yovelas.entity;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class Article {
    private int id;
    private String name;
    private int author;
    private String image;
    private String content;
    private int classfy;
    private int readnum;
    private int likenum;
    private int status;
    private String createTime;
    private String updateTime;

    public Article(int id, String name, int author, String image, String content, int classfy, int readnum, int likenum, int status, String createTime, String updateTime) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.image = image;
        this.content = content;
        this.classfy = classfy;
        this.readnum = readnum;
        this.likenum = likenum;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getClassfy() {
        return classfy;
    }

    public void setClassfy(int classfy) {
        this.classfy = classfy;
    }

    public int getReadnum() {
        return readnum;
    }

    public void setReadnum(int readnum) {
        this.readnum = readnum;
    }

    public int getLikenum() {
        return likenum;
    }

    public void setLikenum(int likenum) {
        this.likenum = likenum;
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", classfy=" + classfy +
                ", readnum=" + readnum +
                ", likenum=" + likenum +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
