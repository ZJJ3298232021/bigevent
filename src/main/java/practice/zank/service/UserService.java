package practice.zank.service;

import practice.zank.entity.Result;
import practice.zank.entity.User;

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

    Result login(String username, String password);
}
