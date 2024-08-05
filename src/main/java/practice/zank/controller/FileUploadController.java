package practice.zank.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import practice.zank.entity.Result;
import practice.zank.util.AliOssUtil;
import practice.zank.util.StringUtil;

import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        if(StringUtil.isEmpty(originalFilename)) {
            return Result.error("未上传文件");
        }
        String fileName = "event/"+UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
        return Result.success(AliOssUtil.uploadFile(fileName, file.getInputStream()));
    }
}
