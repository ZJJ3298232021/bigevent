package practice.zank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.zank.entity.Category;
import practice.zank.entity.User;
import practice.zank.mapper.CategoryMapper;
import practice.zank.service.CategoryService;
import practice.zank.util.ThreadLocalUtil;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        User user = ThreadLocalUtil.get();
        category.setCreateUser(user.getId());
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list() {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        User user = ThreadLocalUtil.get();
        queryWrapper.eq("create_user", user.getId());
        return categoryMapper.selectList(queryWrapper);
    }

    @Override
    public Category getById(Integer id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public void update(Category category) {
        UpdateWrapper<Category> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", category.getId());
        updateWrapper.setSql("update_time = now()");
        categoryMapper.update(category, updateWrapper);
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.deleteById(id);
    }
}
