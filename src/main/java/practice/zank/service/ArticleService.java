package practice.zank.service;

import org.springframework.stereotype.Service;
import practice.zank.entity.Article;
import practice.zank.entity.PageBean;

public interface ArticleService {
    void add(Article article);
    PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId, String state);
}
