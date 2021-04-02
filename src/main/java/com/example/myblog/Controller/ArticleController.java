package com.example.myblog.Controller;

import com.example.myblog.dto.ArticleForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j // 로깅(logging) 기능 추가! Lombok 플러그인 설치 필요!

@Controller
public class ArticleController {
    @GetMapping("/articles")
        public String index(Model model){
        model.addAttribute("msg","안녕하세요~ 반갑습니다!");
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
    }

