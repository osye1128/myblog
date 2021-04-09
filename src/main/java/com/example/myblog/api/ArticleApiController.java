package com.example.myblog.api;


import com.example.myblog.dto.ArticleForm;
import com.example.myblog.dto.CommentForm;
import com.example.myblog.entity.Article;
import com.example.myblog.entity.Comment;
import com.example.myblog.repository.ArticleRepository;
import com.example.myblog.repository.CommentRepository;
import com.example.myblog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ArticleApiController {
    @Autowired
    private  ArticleRepository articleRepository;

    private final ArticleService articleService;

    private final CommentRepository commentRepository;

    @PostMapping("/api/articles") // Post 요청이 "/api/articles" url로 온다면, 메소드 수행!
    public Long create(@RequestBody ArticleForm form) { // JSON 데이터를 받아옴!
        log.info(form.toString()); // 받아온 데이터 확인!
        // dto(데이터-전달-객체)를 entity(db-저장-객체)로 변경
        Article article = form.toEntity();
        // 리파지터리에게(db-관리-객체) 전달
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        // 저장 엔티티의 id(PK)값 반환!
        return saved.getId();
    }

    @GetMapping("/api/articles/{id}")
    public ArticleForm getArticle(@PathVariable Long id) {
        Article entity = articleRepository.findById(id) // id로 article을 가져옴!
                .orElseThrow( // 만약에 없다면,
                        () -> new IllegalArgumentException("해당 Article이 없습니다.") // 에러를 던짐!
                );


        // article을 form으로 변경! 궁극적으로는 JSON으로 변경 됨! 왜? RestController 때문!
        return new ArticleForm(entity);
    }

    @PutMapping("/api/articles/{id}")
    public Long update(@PathVariable Long id,@RequestBody ArticleForm form){
        Article saved = articleService.update(id, form); // 서비스 객체가 update를 수행
        return saved.getId();
    }

    @DeleteMapping("/api/articles/{id}")
    public Long destory(@PathVariable Long id){
        return articleService.destroy(id);
    }


}

