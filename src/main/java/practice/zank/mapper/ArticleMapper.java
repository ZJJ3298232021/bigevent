package practice.zank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import practice.zank.entity.Article;

/**
 * @author zank
 * @description 针对表【article】的数据库操作Mapper
 * @createDate 2024-08-03 21:49:50
 * @Entity practice.zank.entity.Article
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    @Insert("insert into article" +
            "(title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "values" +
            " (#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},now(),now())")
    void add(Article article);
}




