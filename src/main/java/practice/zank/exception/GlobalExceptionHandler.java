package practice.zank.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import practice.zank.entity.Result;
import practice.zank.util.StringUtil;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage());
        return Result.error(StringUtil.isEmpty(e.getMessage()) ? "操作失败" : e.getMessage());
    }
}
