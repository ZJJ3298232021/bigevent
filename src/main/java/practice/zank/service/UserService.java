package practice.zank.service;

import org.springframework.stereotype.Service;
import practice.zank.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author zank
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-08-03 21:49:50
*/
public interface UserService {
    User getUserByUsername(String username);
    void register(String username, String password);
    void update(User user);
    void updateAvatar(String avatar);
    void updatePwd(String oldPwd, String newPwd);
}
