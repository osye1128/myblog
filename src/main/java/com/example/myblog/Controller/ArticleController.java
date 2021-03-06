package com.example.myblog.Controller;

import com.example.myblog.dto.ArticleForm;
import com.example.myblog.entity.Article;
import com.example.myblog.entity.Comment;
import com.example.myblog.repository.ArticleRepository;
import com.example.myblog.repository.CommentRepository;
import com.example.myblog.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Iterator;
import java.util.List;

@Slf4j // 로깅(logging) 기능 추가! Lombok 플러그인 설치 필요!
@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @GetMapping("/articles")
        public String index(Model model){
        Iterable<Article> arrayList = articleRepository.findAll();
        model.addAttribute("articles",arrayList);
            return "articles/index";
        }
    @GetMapping("/articles/new")
    public String newArticle(){
        return "articles/new";
    }

    @PostMapping("/articles") // Post 방식으로 "/articles" 요청이 들어오면, 아래 메소드 수행!
    public String create(ArticleForm form) { // 폼 태그의 데이터가 ArticleForm 객체로 만들어 짐!
        log.info(form.toString()); // ArticleForm 객체 정보를 확인!
        return "redirect:/articles"; // 브라우저를 "/articles" url로 보냄!
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id,Model model){

        Article article = articleRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 Article이 없습니다."));
        log.info(article.toString());
        model.addAttribute("article",article);
        model.addAttribute("comments",article.getComments());
        return "articles/show";
    }

    @GetMapping("/articles/edit/{id}")
    public String edit(@PathVariable Long id,Model model){
        Article target = articleRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 Article이 없습니다."));
        model.addAttribute("article",target);
        return "articles/edit";
    }
    }

