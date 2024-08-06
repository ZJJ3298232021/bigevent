package practice.zank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.zank.entity.Article;
import practice.zank.entity.PageBean;
import practice.zank.entity.User;
import practice.zank.mapper.ArticleMapper;
import practice.zank.service.ArticleService;
import practice.zank.util.StringUtil;
import practice.zank.util.ThreadLocalUtil;

import java.time.LocalDateTime;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void delete(Integer id) {
        articleMapper.deleteById(id);
    }

    @Override
    public void add(Article article) {
        User user = ThreadLocalUtil.get();
        article.setCreateUser(user.getId());
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId, String state) {
        PageBean<Article> pageBean = new PageBean<>();
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        User user = ThreadLocalUtil.get();
        IPage<Article> page = new Page<>(pageNum, pageSize);
        queryWrapper.eq(!StringUtil.isEmpty(state),"state", state);
        queryWrapper.eq(!StringUtil.isEmpty(categoryId),"category_id", categoryId);
        queryWrapper.eq("create_user", user.getId());
        articleMapper.selectPage(page, queryWrapper);
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getRecords());
        return pageBean;
    }

    @Override
    public void update(Article article) {
        UpdateWrapper<Article> updateWrapper = new UpdateWrapper<>();
        User user = ThreadLocalUtil.get();
        updateWrapper.eq("create_user", user.getId());
        updateWrapper.eq("id", article.getId());
        updateWrapper.setSql("update_time=now()");
        articleMapper.update(article, updateWrapper);
    }

    @Override
    public Article getById(Integer id) {
        return articleMapper.selectById(id);
    }
}
