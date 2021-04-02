package com.example.myblog.dto;

import java.beans.ConstructorProperties;

public class ArticleForm {
    private String title;
    private String content;
    private String author;

    @ConstructorProperties({"title", "content", "author"})
    public ArticleForm(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                "author='" + author + '\'' +
                '}';
    }
}