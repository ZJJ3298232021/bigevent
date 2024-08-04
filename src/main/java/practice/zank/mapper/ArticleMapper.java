package practice.zank.mapper;

import org.apache.ibatis.annotations.Mapper;
import practice.zank.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author zank
* @description 针对表【article】的数据库操作Mapper
* @createDate 2024-08-03 21:49:50
* @Entity practice.zank.entity.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}




