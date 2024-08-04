package practice.zank.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import practice.zank.entity.Category;

/**
* @author zank
* @description 针对表【category】的数据库操作Mapper
* @createDate 2024-08-03 21:49:50
* @Entity practice.zank.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




