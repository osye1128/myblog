package com.example.myblog.dto;

import com.example.myblog.entity.Article;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.ConstructorProperties;

@NoArgsConstructor
@Data
public class ArticleForm {
    private Long id;
    private String title;
    private String content;
    private String author;


    public Article toEntity() {
        return Article.builder()
                .id(null)
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

    public ArticleForm(Article entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
    }

    @ConstructorProperties({"title","content","author"})
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