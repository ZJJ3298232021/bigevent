package practice.zank.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import practice.zank.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author zank
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-08-03 21:49:50
* @Entity practice.zank.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user(username,password,create_time,update_time) values(#{username},#{password},now(),now())")
    public void add(@Param("username") String username,@Param("password") String password);

}




