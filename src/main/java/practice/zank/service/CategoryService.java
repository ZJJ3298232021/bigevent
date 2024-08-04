package practice.zank.service;

import practice.zank.entity.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    List<Category> list();

    Category getById(Integer id);

    void update(Category category);

    void delete(Integer id);
}
