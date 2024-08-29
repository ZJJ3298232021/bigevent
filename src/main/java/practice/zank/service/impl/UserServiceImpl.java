package practice.zank.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import practice.zank.entity.Result;
import practice.zank.entity.User;
import practice.zank.mapper.UserMapper;
import practice.zank.service.UserService;
import practice.zank.util.JwtUtil;
import practice.zank.util.SecurityUtil;
import practice.zank.util.ThreadLocalUtil;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author zank
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2024-08-03 21:49:50
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public void register(String username, String password) {
        userMapper.add(username, SecurityUtil.getPassWord(password));
    }

    @Override
    public void updateAvatar(String avatar) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        User user = ThreadLocalUtil.get();
        updateWrapper.eq("id", user.getId());
        updateWrapper.set("user_pic", avatar);
        updateWrapper.set("update_time", LocalDateTime.now());
        userMapper.update(updateWrapper);
    }

    @Override
    public void updatePwd(String oldPwd, String newPwd) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        User user = ThreadLocalUtil.get();
        updateWrapper.eq("id", user.getId());
        updateWrapper.set("password", SecurityUtil.getPassWord(newPwd));
        updateWrapper.set("update_time", LocalDateTime.now());
        userMapper.update(updateWrapper);
        stringRedisTemplate.delete("user:"+ user.getUsername());
    }

    @Override
    public void update(User user) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", user.getId());
        updateWrapper.set("nickname", user.getNickname());
        updateWrapper.set("email", user.getEmail());
        updateWrapper.set("update_time", LocalDateTime.now());
        userMapper.update(user, updateWrapper);
    }

    public Result login(String username,String password) {
        User user = getUserByUsername(username);
        if (user == null) {
            return Result.error("用户不存在");
        }
        if (!SecurityUtil.matches(password, user.getPassword())) {
            return Result.error("密码错误");
        } else {
            String token = JwtUtil.generateToken(user);
            stringRedisTemplate.opsForValue().set("user:"+ user.getUsername() , token);
            stringRedisTemplate.expire("user:"+ user.getUsername(),7, TimeUnit.DAYS);
            return Result.success(token);
        }
    }
}




