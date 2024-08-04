package practice.zank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import practice.zank.entity.User;
import practice.zank.service.UserService;
import practice.zank.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author zank
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-08-03 21:48:08
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




