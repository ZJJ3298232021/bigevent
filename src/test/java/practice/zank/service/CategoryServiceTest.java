package practice.zank.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice.zank.entity.Category;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;
    @Test
    void testUpdate() {
        Category category = new Category();
        category.setId(1);
        category.setCategoryName("测试");
        category.setCategoryAlias("test");
        categoryService.update(category);
    }
}
