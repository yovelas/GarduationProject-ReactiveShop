package com.yovelas.entity;

public class ArticleClassfy {
    private int id;
    private int articleId;
    private int classfyId;

    public ArticleClassfy(int id, int articleId, int classfyId) {
        this.id = id;
        this.articleId = articleId;
        this.classfyId = classfyId;
    }

    public ArticleClassfy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getClassfyId() {
        return classfyId;
    }

    public void setClassfyId(int classfyId) {
        this.classfyId = classfyId;
    }

    @Override
    public String toString() {
        return "ArticleClassfy{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", classfyId=" + classfyId +
                '}';
    }
}
