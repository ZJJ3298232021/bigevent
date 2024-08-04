package practice.zank.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import practice.zank.entity.Result;
import practice.zank.util.StringUtil;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtil.isEmpty(e.getMessage()) ? "操作失败" : e.getMessage());
    }
}
