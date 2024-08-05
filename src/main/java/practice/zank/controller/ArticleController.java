package practice.zank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import practice.zank.entity.Article;
import practice.zank.entity.Result;
import practice.zank.service.ArticleService;

@RestController
@RequestMapping("/article")
@Validated
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }
    @GetMapping
    public Result list(Integer pageNum, Integer pageSize,
                       @RequestParam(required = false) String categoryId,
                       @RequestParam(required = false) String state) {
        return Result.success(articleService.list(pageNum, pageSize, categoryId, state));
    }
}
