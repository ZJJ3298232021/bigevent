package practice.zank.controller;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import practice.zank.entity.Result;
import practice.zank.entity.User;
import practice.zank.service.UserService;
import practice.zank.util.JwtUtil;
import practice.zank.util.SecurityUtil;
import practice.zank.util.ThreadLocalUtil;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public Result register(@Pattern(regexp = "^[a-zA-Z0-9_-]{6,16}$") String username, @Pattern(regexp = "^[a-zA-Z0-9_-]{6,16}$") String password) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return Result.error("用户名已存在");
        }
        userService.register(username, password);
        return Result.success();
    }

    @PostMapping("login")
    public Result login(@Pattern(regexp = "^[a-zA-Z0-9_-]{6,16}$") String username, @Pattern(regexp = "^[a-zA-Z0-9_-]{6,16}$") String password) {
        return userService.login(username, password);
    }

    @GetMapping("userInfo")
    public Result userInfo() {
        User user = ThreadLocalUtil.get();
        User userInfo = userService.getUserByUsername(user.getUsername());
        return Result.success(userInfo);
    }

    @PutMapping("update")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> map) {
        String oldPwd = map.get("old_pwd");
        String newPwd = map.get("new_pwd");
        String rePwd = map.get("re_pwd");
        if (!oldPwd.matches("^[a-zA-Z0-9_-]{6,16}$")
                || !newPwd.matches("^[a-zA-Z0-9_-]{6,16}$")
                || !rePwd.matches("^[a-zA-Z0-9_-]{6,16}$")) {
            return Result.error("密码格式错误");
        }

        User user = ThreadLocalUtil.get();
        User userInfo = userService.getUserByUsername(user.getUsername());
        if (!SecurityUtil.matches(oldPwd, userInfo.getPassword())) {
            return Result.error("旧密码错误");
        }

        if (!newPwd.equals(rePwd)) {
            return Result.error("两次密码不一致");
        }
        userService.updatePwd(oldPwd, newPwd);
        return Result.success();
    }
}
